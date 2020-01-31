package com.wintech.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is same stack implementation but using array instead of linked list
 * Author: Prabu
 * Date: 3/25/12 7:06 PM
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private int N;      // size of stack
    private Item[] items;

    /**
     * Create an empty stack
     */
    public ResizingArrayStack() {
        N = 0;
        items = (Item[]) new Object[1];
    }

    /**
     * Is stack an empty?
     */
    private boolean isEmpty() {
        return N == 0;
    }

    /**
     * Return the number of items in the stack
     * @return
     */
    public int size() {
        return N;
    }

    // Move stack to new array size
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    /**
     * Return the item recently added to the stack
     * @throws RuntimeException if stack is empty
     * @return
     */
    public Item peek() {
        if(isEmpty()) throw new RuntimeException("Stack is underflow.");
        return items[N-1];
    }

    /**
     * Insert an item to the stack
     * @param item
     */
    public void push(Item item) {
        if(N == items.length) resize(2 * items.length);
        items[N] = item;
        N++;
    }

    /**
     * Remove and return the item recently added to the stack
     * @throws RuntimeException if stack is empty
     * @return
     */
    public Item pop() {        
        if(isEmpty()) throw new RuntimeException("Stack is underflow.");
        N--;
        Item item = items[N];
        items[N] = null; // to avoid loitering
        if(N > 0 && N == items.length/4) resize(items.length/2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // An iterator for this stack
    private class ReverseArrayIterator implements Iterator<Item> {
        int index = N;

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            index--;
            return items[index];
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
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
        String input = "it was - the best - of times - - - it was - the - -";
        String[] array = input.split("\\s+");
        System.out.println("Given input: " + input);
        for(String item: array) {
            if(!item.equals("-")) stack.push(item);
            else if(!stack.isEmpty()) System.out.println("Dequeued item - " + stack.pop());
        }

        System.out.printf("Remaining stack items %s and its size %d.\n\n", stack, stack.size());

        // Arithmetic expression evaluation
        ResizingArrayStack<String> ops = new ResizingArrayStack<String>();    // To hold operators
        ResizingArrayStack<Double> vals = new ResizingArrayStack<Double>();   // To hold operands
        String expression = "( ( 1 + sqrt ( 5.0 ) ) / 2.0 )"; //"( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
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
