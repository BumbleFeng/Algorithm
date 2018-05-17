package edu.neu.coe.info6205.sort.par;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

class ParSort {

    public static int cutoff = 1000;

    public static void sort(int[] array, int from, int to) {
        int size = to - from;
        if (size <= cutoff) {
            Arrays.sort(array, from, to);
        } else {
            int mid = from + (to - from) / 2;
            CompletableFuture<int[]> parsort1 = parsort(array, from, mid);
            CompletableFuture<int[]> parsort2 = parsort(array, mid, to);
            CompletableFuture<int[]> parsort = parsort1.
                    thenCombine(parsort2, (xs1, xs2) -> {
                        //System.out.println("Count:"+Thread.activeCount());
                        //System.out.println(Thread.currentThread().getName()+" Combine From:" +from +" To:" +to);
                        int[] result = new int[xs1.length + xs2.length];
                        int i = 0;
                        int j = 0;
                        for (int k = 0; k < result.length; k++) {
                            if (i >= xs1.length) {
                                result[k] = xs2[j++];
                            } else if (j >= xs2.length) {
                                result[k] = xs1[i++];
                            } else if (xs2[j] < xs1[i]) {
                                result[k] = xs2[j++];
                            } else {
                                result[k] = xs1[i++];
                            }
                        }
                        return result;
                    });

            parsort.whenComplete((result, throwable) -> {
                for (int i = 0; i < result.length; i++) {
                    array[i] = result[i];
                }
            });
            parsort.join();
        }
    }

    private static CompletableFuture<int[]> parsort(int[] array, int from, int to) {
        return CompletableFuture.supplyAsync(
                () -> {
                    //System.out.println("Count:"+Thread.activeCount());
                    //System.out.println(Thread.currentThread().getName()+" Sort From:" +from +" To:" +to);
                    int[] result = new int[to - from];
                    for (int i = 0; i < result.length; i++) {
                        result[i] = array[from + i];
                    }
                    sort(result, 0, result.length);
                    return result;
                }
        );
    }
}
