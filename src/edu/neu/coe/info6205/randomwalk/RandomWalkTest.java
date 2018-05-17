/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.randomwalk;

/**
 *
 * @author BumbleBee
 */
public class RandomWalkTest {
    private RandomWalk mans[];

    public RandomWalkTest() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int t = 1000;
        int l = 1;
        int a = 100;
        int g = 100;
        double avg[] = new double[t/g];
        
        for(int i = 0 ; i < t ; i+=g){
            RandomWalkTest rw = new RandomWalkTest();
            rw.mans = new RandomWalk[a];
            for(int j = 0 ; j < a ;j++){
                rw.mans[j]= new RandomWalk(l);
                avg[i/g]+=rw.mans[j].walk(i);
            }
            avg[i/g]/=a;
        }
        
        for(double av :avg){
            System.out.println(av);
        }
    }
    
}
