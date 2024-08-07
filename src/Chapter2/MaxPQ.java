package Chapter2;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;
    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    public void insert(Key x) {
        pq[++ N] = x;
        swim(N);
    }
    public Key delMax() {
        Key max = pq[1];
        exch(1, N --);
        pq[N + 1] = null;
        sink(1);
        return max;
    }
    private void swim(int k) {
        while(k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }
    private void sink(int k) {
        while(2 * k <= N) {
            int j = 2 * k;
            if(j < N && less(j, j + 1))
                j ++;
            if(!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }
    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>(10);

        // Insert elements
        pq.insert(3);
        pq.insert(10);
        pq.insert(5);
        pq.insert(1);
        pq.insert(2);

        // Print the size of the priority queue
        System.out.println("Size: " + pq.size());

        // Remove elements and print them
        System.out.println("Max: " + pq.delMax()); // Should print 10
        System.out.println("Max: " + pq.delMax()); // Should print 5
        System.out.println("Max: " + pq.delMax()); // Should print 3
        System.out.println("Max: " + pq.delMax()); // Should print 2
        System.out.println("Max: " + pq.delMax()); // Should print 1

        // Check if the priority queue is empty
        System.out.println("Is empty: " + pq.isEmpty());
    }
}
