/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.randomwalk;

import java.awt.Point;
import java.util.Random;

/**
 *
 * @author BumbleBee
 */
public class RandomWalk {
    private Point d;
    private int l;
    
    public RandomWalk(int l){
        d = new Point(0, 0);
        this.l = l;
    }
    
    public void step(int x){
        switch(x){
            case 0:
               d.x+=l;
               break;
            case 1:
               d.x-=l;
               break;
            case 2:
               d.y+=l;
               break;
            case 3:
               d.y-=l;
               break;
       }
    }
    
    public double distance(){
        return (d.x * d.x + d.y * d.y);
    }
    
    public double walk(int n){
        Random r = new Random();
        for(int i = 0; i < n ; i++){
            step(r.nextInt(4));
        }
        return distance();
    }
}
