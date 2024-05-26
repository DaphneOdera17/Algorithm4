package Chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFind {
    private int[] id;
    private int count;
    public UnionFind(int N) {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i ++)
            id[i] = i;
    }
    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public int find(int p) {
        if(id[p] != p)
            p = find(id[p]);
        return id[p];
    }
    /*
    *
    * while(id[p] != p)
    *   p = id[p];
    * return p ;
    *
    */
    public void union(int p, int q) {
        int fp = find(p);
        int fq = find(q);

        if(fp == fq)
            return ;

        id[fp] = fq;
        count --;
    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UnionFind uf = new UnionFind(N);
        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if(uf.connected(p, q))
                continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println();
        StdOut.println(uf.count() + " components");
    }
}
