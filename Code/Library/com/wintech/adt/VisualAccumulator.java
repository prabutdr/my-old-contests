package com.wintech.adt;

import com.wintech.draw.Draw;
import com.wintech.util.StdRandom;

import java.awt.*;

/**
 * Author: Prabu
 * Date: 3/24/12 9:45 PM
 */
public class VisualAccumulator {
    private int N;
    private double total;
    Draw draw;

    // Create an accumulator
    public VisualAccumulator(int trials, double max) {
        total = 0;
        N = 0;
        draw = new Draw("Visual Accumulator");
        draw.setXscale(0, trials);
        draw.setYscale(0, max);
        //draw.setPenRadius(trials*0.002/512);
        //draw.show();
    }

    // Add data value to accumulator
    public void addDataValue(double data) {
        total = total + data;
        N++;
        draw.setPenColor(Color.GRAY);
        draw.point(N, data);
        draw.setPenColor(Color.red);
        draw.point(N, total/N);
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
        VisualAccumulator accumulator = new VisualAccumulator(T, 1);
        for(int i = 0; i < T; i++) {
            accumulator.addDataValue(StdRandom.uniform());
        }
        /*for(int i = 0; i < T/2; i++) {
            accumulator.addDataValue(StdRandom.uniform(0, 0.5));
        } */

        System.out.println(accumulator);
    }
}
