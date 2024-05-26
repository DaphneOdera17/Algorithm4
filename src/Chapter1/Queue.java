package Chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;
    private class Node {
        Item item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return N;
    }
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        N++;
    }
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            first = last; // 如果删除完队列为空
        N --;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        @Override
        public void remove() {}
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();

        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(!item.equals("-")) {
                q.enqueue(item);
            }
            else if (!q.isEmpty())
                StdOut.print(q.dequeue() + " ");
        }

        StdOut.println("( " + q.size() + " left on queue )");
    }
}
