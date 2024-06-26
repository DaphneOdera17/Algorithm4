package Chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.concurrent.ConcurrentMap;

public class MergeSortBU {
    private static Comparable[] aux; // 归并排序的辅助数组
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for(int sz = 1; sz < N; sz *= 2) {
            for(int lo = 0; lo < N - sz; lo += 2 * sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1));
            }
        }
    }
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k ++)
            aux[k] = a[k];
        for(int k = lo; k <= hi; k ++) {
            if(i > mid)
                a[k] = aux[j ++];
            else if(j > hi)
                a[k] = aux[i ++];
            else if(less(aux[j], aux[i]))
                a[k] = aux[j ++];
            else
                a[k] = aux[i ++];
        }
    }
    public static void show(Comparable[] a) {
        for(int i = 0; i < a.length; i ++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
    public static boolean isSorted(Comparable[] a) {
        for(int i = 1; i < a.length; i ++) {
            if(less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
