package edu.neu.coe.info6205.hashtable;

import java.util.Random;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void testHashTable0() {
        final ST st = new ST(2);
        assertEquals(2, st.count);
    }

    @Test
    public void testHashTable1() {
        final ST st = new ST(3);
        assertNull(st.get("Hello"));
    }

    @Test
    public void testHashTable2() {
        final ST st = new ST(4);
        st.put("Hello", "World!");
        assertEquals(3, st.count);
        assertNotNull(st.get("Hello"));
        assertEquals("World!", st.get("Hello"));
    }

    @Test
    public void testHashTable3() {
        final ST st = new ST(4);;
        st.put("Hello0", "World!0");
        st.put("Hello1", "World!1");
        assertEquals(2, st.count);
        assertNotNull(st.get("Hello0"));
        assertNotNull(st.get("Hello1"));
        assertEquals("World!0", st.get("Hello0"));
        assertEquals("World!1", st.get("Hello1"));
    }

    @Test
    public void testHashTable4() {
        Random random = new Random();
        int m = 100;
        ST st = new ST(m);
        while (st.collision == false) {
            Integer key = random.nextInt();
            Integer val = 0;
            st.put(key, val);
        }
        boolean test = false;
        for (int i = 0; i < m; i++) {
            if((st.st[i]!=null)&&(st.st[i].next!=null)) test=true;
        }
        assertTrue(test);
    }
    
    @Test
    public void testHashTable5() {
        Random random = new Random();
        int m = 100;
        ST st = new ST(m);
        while (st.count != 0) {
            Integer key = random.nextInt();
            Integer val = 0;
            st.put(key, val);
        }
        for (int i = 0; i < m; i++) {
            assertNotNull(st.st[i]);
        }
    }
}
