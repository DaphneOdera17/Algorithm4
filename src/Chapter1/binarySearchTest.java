package Chapter1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Elio Yang on 2020/6/28.
 */
public class binarySearchTest {
    public static int rank(int key,int[] a){
        int lo=0;
        int hi=a.length-1;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(key<a[mid]) hi=mid-1;
            else if(key>a[mid]) lo=mid+1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] arraylist= new In(args[0]).readAllInts();
        int[] arraylist = new int[10];
        for(int i = 0; i < 10; i ++)
            arraylist[i] = 10 - i;

        Arrays.sort(arraylist);
        while (!StdIn.isEmpty()){
            int key=StdIn.readInt();

            StdOut.println(rank(key,arraylist));
        }
    }
}

