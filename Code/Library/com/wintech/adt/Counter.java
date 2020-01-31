/**
 * @author Prabu
 * @date Mar 8, 2012
 */
package com.wintech.adt;

import com.wintech.io.StdOut;
import com.wintech.util.StdRandom;

public class Counter {
    private String id;  // Name of counter
    private int value;  // Current value of counter
            
    /**
     * Create an counter with given name
     * 
     * @param id 
     */
    public Counter(String id) {
        this.id = id;
        this.value = 0;
    }
    
    /**
     * Increment counter by one
     * 
     */
    public void increment() {
        this.value++;
    }
    
    /**
     * To get current value of counter
     * 
     * @return 
     */
    public int tally() {
        return this.value;
    }
    
    /**
     * String representation of counter
     * 
     * @return 
     */
    @Override
    public String toString() {
        return this.value + " " + id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Counter that = (Counter) obj;

        return this.tally() == that.tally();

    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + this.tally();
        return hash;
    }

    /**
     * Test client
     * @param args 
     */
    public static void main(String[] args) {
        int N = 10; // Number of counters
        int T = 100; // Number of trials
        
        // Create N counters
        Counter[] hits = new Counter[N];
        for(int i = 0; i < N; i++) {
            hits[i] = new Counter("counter" + (i+1));
        }
        
        // Increment counters T times randomly
        for(int i = 0; i < T; i++) {
            hits[StdRandom.uniform(N)].increment();
        }
        
        // Print counters
        for(int i = 0; i < N; i++) {
            StdOut.println(hits[i]);
        }
    }
}
