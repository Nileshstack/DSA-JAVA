import java.util.*;

class MyHashSet {
    private int M; 
    private List<Integer>[] buckets;

    public MyHashSet() {
        M = 15000; // bucket size
        buckets = new List[M];
        for (int i = 0; i < M; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getIndex(int key) {
        return key % M;
    }

    public void add(int key) {
        int index = getIndex(key);
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        buckets[index].remove((Integer) key);
    }

    public boolean contains(int key) {
        int index = getIndex(key);
        return buckets[index].contains(key);
    }
}
