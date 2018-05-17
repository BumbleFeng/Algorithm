package edu.neu.coe.info6205.sort.par;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.cutoff();
        //m.depth();
    }

    public void cutoff() {
        for (int c = 150000; c >= 1000; c -= 1000) {
            ParSort.cutoff = c;
            double t = 0;
            for (int i = 0; i < 100; i++) {
                Double d = time(128000);
            }
            for (int i = 0; i < 1000; i++) {
                t += time(128000);
            }
            System.out.println(c + " " + t);
        }
    }

    public void depth() {
        for (int c = 250; c <= 128000; c += c) {
            ParSort.cutoff = c;
            double t = 0;
            for (int i = 0; i < 100; i++) {
                Double d = time(128000);
            }
            for (int i = 0; i < 1000; i++) {
                t += time(128000);
            }

            System.out.println(c + " " + t);
        }
    }

    public double time(int n) {
        Random random = new Random(0L);
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000000);
        }
        double x = System.nanoTime();
        ParSort.sort(array, 0, array.length);
        x = (System.nanoTime() - x);
        return x;
    }

}
