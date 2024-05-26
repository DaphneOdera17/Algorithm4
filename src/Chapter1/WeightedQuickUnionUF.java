package Chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
    private int id[];
    private int sz[];
    private int count;
    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i ++) {
            id[i] = i;
            sz[i] = 1;
        }
    }
    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public int find(int x) {
        if(x != id[x]) {
            x = find(id[x]);
        }
        return id[x];
    }
    public void union(int p, int q) {
        int fp = find(p);
        int fq = find(q);
        if(fp == fq)
            return ;
        if(sz[fp] < sz[fq]) {
            id[fp] = fq;
            sz[fq] += sz[fp];
        }
        else {
            id[fq] = fp;
            sz[fp] += sz[fq];
        }
        count --;
    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
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

