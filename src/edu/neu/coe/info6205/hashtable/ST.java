package edu.neu.coe.info6205.hashtable;

public class ST<Key, Value> {

    protected int M;
    protected Node[] st;
    protected int count;
    protected boolean collision = false;


    public ST(int M) {
        this.M = M;
        st = new Node[M];
        count = M;
    }

    protected static class Node {

        protected Object key;
        protected Object val;
        protected Node next;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return (Value) x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        int i = hash(key);
        if (st[i] != null) {
            collision = true;
        }else{
            count--;
        }
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        st[i] = new Node(key, val, st[i]);
    }

}
