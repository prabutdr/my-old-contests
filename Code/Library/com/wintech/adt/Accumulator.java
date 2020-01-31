package com.wintech.adt;

import com.wintech.util.StdRandom;

/**
 * Author: Prabu
 * Date: 3/24/12 9:33 PM
 */
public class Accumulator {

    private int N;
    private double total;

    // Create an accumulator
    public Accumulator() {
        total = 0;
        N = 0;
    }

    // Add data value to accumulator
    public void addDataValue(double data) {
        total = total + data;
        N++;
    }

    // Calculate mean so far
    public double mean() {
        return total / N;
    }

    @Override
    public String toString() {
        return String.format("Mean (%d values): %8.2f", N, mean());
    }

    // Test client (Default)
    public static void main(String[] args) {
        int T = 100;
        Accumulator accumulator = new Accumulator();
        for(int i = 0; i < T; i++) {
            accumulator.addDataValue(StdRandom.uniform());
        }

        System.out.println(accumulator);
    }
}
