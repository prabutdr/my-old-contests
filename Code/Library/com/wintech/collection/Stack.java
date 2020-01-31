package com.wintech.collection;

import com.wintech.io.StdIn;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents the stack of generic items, last-in-first-out (LIFO)
 *
 * Author: Prabu
 * Date: 3/25/12 5:45 PM
 */
public class Stack <Item> implements Iterable<Item> {
    private int N;      // size of stack
    private Node first; // first element of stack

    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Create an empty stack
     */
    public Stack() {
        N = 0;
        first = null;
    }

    /**
     * Is stack an empty?
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Return the number of items in the stack
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * Return the item recently added to the stack
     * @throws RuntimeException if stack is empty
     * @return
     */
    public Item peek() {
        if(isEmpty()) throw new RuntimeException("Stack is underflow.");
        return first.item;
    }

    /**
     * Insert an item to the stack
     * @param item
     */
    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
        N++;
    }

    /**
     * Remove and return the item recently added to the stack
     * @throws RuntimeException if stack is empty
     * @return
     */
    public Item pop() {
        if(isEmpty()) throw new RuntimeException("Stack is underflow.");
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    /**
     * Return copy of given stack
     * @param source
     * @return
     */
    public static <E> Stack<E> copy(Stack<E> source) {
        if(source.isEmpty()) return new Stack<E>();
        E[] elements = (E[]) new Object[source.size()];
        int i = 0;
        for(E item: source) {
            elements[i] = item;
            i++;
        }

        Stack<E> result = new Stack<E>();
        for(i--; i >= 0; i--) {
            result.push(elements[i]);
        }
        return result;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    // An iterator for this stack
    private class StackIterator implements Iterator<Item> {
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
            throw new UnsupportedOperationException("Remove not allowed on iteration.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Item item: this) {
            sb.append(item).append(", ");
        }
        if(this.size() > 0) {  // remove ", " for last element
            sb.delete(sb.length()-2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    // Test client (Default)
    public static void main(String[] args) {
        /*Stack<String> stack = new Stack<String>();
        String[] array = {"test", "-", "-", "test1", "test2", "test3", "-", "-"};

        for(String item: array) {
            if(!item.equals("-")) stack.push(item);
            else if(!stack.isEmpty()) System.out.println("Dequeued item - " + stack.pop());
        }

        System.out.printf("Remaining stack items %s and its size %d.", stack, stack.size());*/
        
        // Arithmetic expression evaluation (Infix notation)
        Stack<String> ops = new Stack<String>();    // To hold operators
        Stack<Double> vals = new Stack<Double>();   // To hold operands
        String expression = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )"; //"( ( 1 + sqrt ( 5.0 ) ) / 2.0 )"; //"( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String[] tokens = expression.split("\\s+");
        for(String token: tokens) {
            if(token.equals("("))   ;
            else if(token.equals("+"))  ops.push(token);
            else if(token.equals("-"))  ops.push(token);
            else if(token.equals("*"))  ops.push(token);
            else if(token.equals("/"))  ops.push(token);
            else if(token.equals("sqrt"))  ops.push(token);
            else if(token.equals(")")) {
                // Pop, evaluate and push result if token is ")"
                String op = ops.pop();
                double v = vals.pop();
                if(op.equals("+"))          v = vals.pop() + v;
                else if(op.equals("-"))     v = vals.pop() - v;
                else if(op.equals("*"))     v = vals.pop() * v;
                else if(op.equals("/"))     v = vals.pop() / v;
                else if(op.equals("sqrt"))  v = Math.sqrt(v);
                vals.push(v);
            }
            else { // then some operand
                vals.push(Double.parseDouble(token));
            }
        }
        System.out.printf("Result of expression %s is %f", expression, vals.pop());
    }
}
