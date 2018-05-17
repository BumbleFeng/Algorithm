/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.sort.par;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.util.Random;

/**
 *
 * @author BumbleBee
 */
@SuppressWarnings("ALL")
public class ParSortTest {
    
    @Test
    public void sort() throws Exception {

        Random random = new Random(0L);
        int[] array = new int[2000];
        for (int i = 0; i < array.length; i++) array[i] = random.nextInt(10000);
        ParSort.sort(array, 0, array.length);
        assertEquals(11,array[0]);
        for(int i = 0; i < array.length-1; i++){
            assertEquals(true,array[i]<=array[i+1]);
        }
    }
}
