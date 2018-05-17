package edu.neu.coe.info6205.hashtable;

import java.util.Random;

public class HashTable {

    public static void main(String[] args) {
        HashTable ht = new HashTable();
        System.out.println("the Birthday Problem");
        for (int n = 1000; n <= 100000; n += 1000) {
            double collision = ht.c(n);
            System.out.println(n + " " + collision);
        }
        System.out.println("the Coupon Collector's Problem");
        for (int n = 100; n <= 10000; n += 100) {
            double filled = ht.b(n);
            System.out.println(n + " " + filled);
        }
    }

    public double c(int n) {
        Random random = new Random();
        double c = 0;
        for (int i = 0; i < 1000; i++) {
            ST st = new ST(n);
            while (st.collision == false) {
                Integer key = random.nextInt();
                Integer val = 0;
                st.put(key, val);
                c++;
            }
        }
        return c / 1000.0;
    }

    public double b(int n) {
        Random random = new Random();
        double b = 0;
        for (int i = 0; i < 1000; i++) {
            ST st = new ST(n);
            while (st.count != 0) {
                Integer key = random.nextInt();
                Integer val = 0;
                st.put(key, val);
                b++;
            }
        }
        return b / 1000.0;
    }

}
