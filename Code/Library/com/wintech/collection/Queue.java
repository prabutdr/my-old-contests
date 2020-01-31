package com.wintech.collection;

import com.wintech.io.StdIn;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue <Item> implements Iterable<Item> {
    private int N;      // size of queue
    private Node first; // first element of queue
    private Node last;  // last element of queue
    
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Create an empty queue
     */
    public Queue() {
        N = 0;
        first = null;
        last = null;
    }

    /**
     * Is queue an empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Return the number of items in the queue
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * Return the item least recently added to the queue
     * @throws RuntimeException if queue is empty
     * @return
     */
    public Item peek() {
        if(isEmpty()) throw new RuntimeException("Queue is underflow.");
        return first.item;
    }

    /**
     * Insert an item to the queue
     * @param item
     */
    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = null;
        if(isEmpty()) {
            last = first = node;
        }
        else {
            last.next = node;
            last = node;
        }

        N++;
    }

    /**
     * Remove and return the item least recently added to the queue
     * @throws RuntimeException if queue is empty
     * @return
     */
    public Item dequeue() {
        if(isEmpty()) throw new RuntimeException("Queue is underflow.");
        Item item = first.item;
        first = first.next;
        N--;
        if(isEmpty()) last = null; // to avoid loitering
        return item;
    }

    /**
     * Remove all elements from the queue
     */
    public void clear() {
        N = 0;
        first = null;
        last = null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    // An iterator for this queue
    private class QueueIterator implements Iterator<Item> {
        Node currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            Item result = currentNode.item;
            currentNode = currentNode.next;
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not allowed.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Item item: this) {
            sb.append(item + ", ");
        }
        if(this.size() > 0) {  // remove ", " for last element
            sb.delete(sb.length()-2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    // Test client (Default)
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        String[] array = {"test", "-", "-", "test1", "test2", "test3", "-", "-"};
        
        for(String item: array) {
            if(!item.equals("-")) queue.enqueue(item);
            else if(!queue.isEmpty()) System.out.println("Dequeued item - " + queue.dequeue());
        }

        System.out.printf("Remaining queue %s and its size %d.", queue, queue.size());
    }
}
