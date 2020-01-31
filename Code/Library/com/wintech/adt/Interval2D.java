package com.wintech.adt;

import com.wintech.draw.StdDraw;
import com.wintech.io.StdOut;
import com.wintech.util.StdRandom;

/*************************************************************************
 *  Compilation:  javac Interval2D.java
 *  Execution:    java Interval2D
 *
 *  2-dimensional interval data type.
 *
 *************************************************************************/

public class Interval2D {
    private final Interval1D x;
    private final Interval1D y;

    public Interval2D(Interval1D x, Interval1D y) {
        this.x = x;
        this.y = y;
    }

    // does this interval intersect that one?
    public boolean intersects(Interval2D that) {
        if (!this.x.intersects(that.x)) return false;
        if (!this.y.intersects(that.y)) return false;
        return true;
    }

    // does this interval contain x?
    public boolean contains(Point2D p) {
        return x.contains(p.x())  && y.contains(p.y());
    }

    // does this interval contain that?
    public boolean contains(Interval2D that) {
        return this.x.contains(that.x) && this.y.contains(that.y);
    }

    // area of this interval
    public double area() {
        return x.length() * y.length();
    }

    public String toString() {
        return x + " x " + y;
    }

    public void draw() {
        double xc = (x.left() + x.right()) / 2.0;
        double yc = (y.left() + y.right()) / 2.0;
        StdDraw.rectangle(xc, yc, x.length() / 2.0, y.length() / 2.0);
    }

    // Test client
    public static void main(String[] args) {
        double xlo = 0.1;
        double xhi = 0.9;
        double ylo = 0.4;
        double yhi = 0.5;
        int T = 1000;

        Interval1D x = new Interval1D(xlo, xhi);
        Interval1D y = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(x, y);
        
        box.draw();

        Counter hits = new Counter("hits");
        for (int i = 0; i < T; i++) {
            double x1 = StdRandom.uniform();
            double y1 = StdRandom.uniform();
            Point2D point = new Point2D(x1, y1);
            if(box.contains(point))
                hits.increment();
            else
                point.draw();
        }

        System.out.printf("Total number of hits in the box %s is - %d\n", box, hits.tally());
        System.out.println("Area of box: " + box.area());
    }
}
