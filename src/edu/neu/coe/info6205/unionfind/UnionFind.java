/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.unionfind;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author BumbleBee
 */
public class UnionFind {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
        
        int max = 1000;
        int g = 10;
        int t = 100;
        
        for (int n = g; n <= max; n+=g) {
            int c = 0;
            for (int m = 0; m < t; m++) {
                WQUPC up = new WQUPC(n);
                ArrayList<int[]> pairs = new ArrayList<int[]>();    
                
                for (int i = 0; i < n; i++) {
                    for (int j = i+1; j < n; j++) {
                        int p[]=new int[2];
                        p[0]=i;
                        p[1]=j;
                        pairs.add(p);
                    }
                }                
                
                while (up.count()!=1) {                                    
                    Random random = new Random();
                    
                    int i = random.nextInt(pairs.size());
                    int p[]=new int[2];
                    p=pairs.get(i);
                    pairs.remove(i);
//                    int x = random.nextInt(n);
//                    int y;
//                    do {            
//                        y = random.nextInt(n);
//                    } while (x==y);

                    if (!up.connected(p[0], p[1])) {
                        up.union(p[0], p[1]);
                    }
                    c++;
                }
            }
            double a = (double)c/t;
            System.out.println(n+" "+a);
        }
    }
}
