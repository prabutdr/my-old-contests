package com.wintech.collection;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents a bag (or mutiset) of generic items, and removal of item not allowed.
 *
 * Author: Prabu
 * Date: 3/25/12 5:09 PM
 */
public class Bag <Item> implements Iterable <Item> {
    private int N;      // number of elements in the bag
    private Node first; // first elment in the bag
    
    private class Node {
        private Item item;
        private Node next;
    }

    // Create an empty bag
    public Bag() {
        N = 0;
        first = null;
    }

    // Is the bag empty?
    public boolean isEmpty() {
        return first == null;
    }
    
    // Return the number of items in the bag
    public int size() {
        return N;
    }
    
    public void add(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    // An iterator for bag class
    private class BagIterator implements Iterator<Item> {
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
        double[] array = {10, 67.8, 9, 45.5, 100.1, 34, 18};
        
        Bag<Double> numbers = new Bag<Double>();
        for(double a: array) {
            numbers.add(a);
        }

        // Calculate mean
        int N = numbers.size();
        double sum = 0.0;
        for(double x: numbers) {
            sum += x;
        }
        double mean = sum / N;

        // Calculate stddev
        sum = 0.0;
        for(double x: numbers) {
            sum += (mean - x) * (mean - x);
        }
        double std = Math.sqrt(sum/(N-1));

        System.out.printf("Numbers - %s\n", numbers);
        System.out.printf("Mean: %.2f\n", mean);
        System.out.printf("Std dev: %.2f\n", std);
    }
}
