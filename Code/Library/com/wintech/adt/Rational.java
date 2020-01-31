package com.wintech.adt;

import com.wintech.util.MathUtil;
import com.wintech.util.StdRandom;

/**
 * Author: Prabu
 * Date: 3/25/12 2:31 PM
 */
public class Rational {
    private long numerator;
    private long denominator;
    private boolean positiveInd;

    public Rational(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        optimize();
    }

    private void optimize() {
        if(this.numerator == 0) {
            positiveInd = true;
            this.denominator = 1;
        }
        /*else if(this.denominator == 0) {
            positiveInd = true;
            this.numerator = 1;
        }*/
        else if(this.numerator < 0 && this.denominator >= 0) {
            positiveInd = false;
            this.numerator *= -1;
        }
        else if(this.numerator >= 0 && this.denominator < 0) {
            positiveInd = false;
            this.denominator *= -1;
        }
        else if(this.numerator < 0 && this.denominator < 0) {
            positiveInd = true;
            this.numerator *= -1;
            this.denominator *= -1;
        }
        else {
            positiveInd = true;
        }
        
        long gcd = gcd(this.numerator, this.denominator);
        numerator /= gcd;
        denominator /= gcd;
    }
    
    private long gcd(long a, long b) {
        long tmp;
        while(b != 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
    
    public Rational plus(Rational that) {
        long n, d;

        if(this.positiveInd == true && that.positiveInd == false) { // a + (-b) = a - b
            return this.minus(new Rational(that.numerator, that.denominator));
        }
        else if(this.positiveInd == false && that.positiveInd == false) { // -a + (-b) = -(a+b)
            Rational t = new Rational(this.numerator, this.denominator).plus(new Rational(that.numerator, that.denominator));
            t.positiveInd = false;
            return t;
        }
        else if(this.positiveInd == false && that.positiveInd == true) { // -a + b = b - a
            return new Rational(that.numerator, that.denominator).minus(new Rational(this.numerator, this.denominator));
        }


        if(this.denominator == that.denominator) {
            n = this.numerator + that.numerator;
            d = this.denominator;
        }
        else {
            n = (this.numerator * that.denominator) + (this.denominator * that.numerator);
            d = this.denominator * that.denominator;
        }

        return new Rational(n, d);
    }
    
    public Rational minus(Rational that) {
        long n, d;

        if(this.positiveInd == true && that.positiveInd == false) { // a - (-b) = a + b
            return this.plus(new Rational(that.numerator, that.denominator));
        }
        else if(this.positiveInd == false && that.positiveInd == false) { // -a - (-b) = b - a
            return new Rational(that.numerator, that.denominator).minus(new Rational(this.numerator, this.denominator));
        }
        else if(this.positiveInd == false && that.positiveInd == true) { // -a - b = -(a+b)
            Rational t = new Rational(this.numerator, this.denominator).plus(new Rational(that.numerator, that.denominator));
            t.positiveInd = false;
            return t;
        }


        if(this.denominator == that.denominator) {
            n = this.numerator - that.numerator;
            d = this.denominator;
        }
        else {
            n = (this.numerator * that.denominator) - (this.denominator * that.numerator);
            d = this.denominator * that.denominator;
        }

        return new Rational(n, d);
    }
    
    public Rational times(Rational that) {
        Rational t = new Rational(this.numerator * that.numerator, this.denominator * that.denominator);
        if(this.positiveInd != that.positiveInd)
            t.positiveInd = false;
        return t;
    }
    
    public Rational divides(Rational that) {
        Rational t = new Rational(this.numerator * that.denominator, this.denominator * that.numerator);
        if(this.positiveInd != that.positiveInd)
            t.positiveInd = false;
        return t;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Rational that = (Rational) obj;

        if(this.positiveInd != that.positiveInd) return false;
        return (this.numerator * that.denominator) == (this.denominator * that.numerator);
    }

    @Override
    public String toString() {
        String result;
        if(numerator == 0) return "0";
        if(denominator == 0) return "infinity";
        
        if(positiveInd) result = ""; else result = "-";
        
        if(denominator == 1) result += numerator;
        else result += (numerator + "/" + denominator);

        return result;
    }

    // Test client (Default)
    public static void main(String[] args) {
        System.out.println("5/3: " + new Rational(5, 3));
        System.out.println("-5/3: " + new Rational(-5, 3));
        System.out.println("5/-3: " + new Rational(5, -3));
        System.out.println("-5/-3: " + new Rational(-5, -3));
        System.out.println("-5/1: " + new Rational(-5, 1));
        System.out.println("5/-1: " + new Rational(5, -1));
        System.out.println("-5/-1: " + new Rational(-5, -1));
        System.out.println("5/1: " + new Rational(5, 1));
        System.out.println("1/1: " + new Rational(1, 1));
        System.out.println("10/0: " + new Rational(10, 0));
        System.out.println("-10/0: " + new Rational(-10, 0));
        System.out.println("0/10: " + new Rational(0, 10));
        System.out.println("0/-10: " + new Rational(0, -10));
        System.out.println("5/10: " + new Rational(5, 10));
        System.out.println("5/-10: " + new Rational(5, -10));

        // Gcd calculation check
        Rational t = new Rational(5, 6);
        for(int i = 0; i < 100; i++) {
            int a = StdRandom.uniform(Integer.MAX_VALUE);
            int b = StdRandom.uniform(Integer.MAX_VALUE);
            if(t.gcd(a, b) != MathUtil.gcd(a, b)) {
                System.out.printf("FAILED gcd comparison for %d and %d.", a, b);
            }
        }
        
        Rational a1 = new Rational(5, 3);
        Rational b1 = new Rational(2, 3);
        System.out.printf("%s + %s: %s\n", a1, b1, a1.plus(b1));
        System.out.printf("%s + %s: %s\n", b1, a1, b1.plus(a1));
        System.out.printf("%s - %s: %s\n", a1, b1, a1.minus(b1));
        System.out.printf("%s - %s: %s\n", b1, a1, b1.minus(a1));
        System.out.printf("%s * %s: %s\n", a1, b1, a1.times(b1));
        System.out.printf("%s * %s: %s\n", b1, a1, b1.times(a1));
        System.out.printf("%s / %s: %s\n", a1, b1, a1.divides(b1));
        System.out.printf("%s / %s: %s\n", b1, a1, b1.divides(a1));
        a1 = new Rational(-5, 3);
        b1 = new Rational(2, 3);
        System.out.printf("%s + %s: %s\n", a1, b1, a1.plus(b1));
        System.out.printf("%s + %s: %s\n", b1, a1, b1.plus(a1));
        System.out.printf("%s - %s: %s\n", a1, b1, a1.minus(b1));
        System.out.printf("%s - %s: %s\n", b1, a1, b1.minus(a1));
        System.out.printf("%s * %s: %s\n", a1, b1, a1.times(b1));
        System.out.printf("%s * %s: %s\n", b1, a1, b1.times(a1));
        System.out.printf("%s / %s: %s\n", a1, b1, a1.divides(b1));
        System.out.printf("%s / %s: %s\n", b1, a1, b1.divides(a1));
        a1 = new Rational(5, 3);
        b1 = new Rational(-2, 3);
        System.out.printf("%s + %s: %s\n", a1, b1, a1.plus(b1));
        System.out.printf("%s + %s: %s\n", b1, a1, b1.plus(a1));
        System.out.printf("%s - %s: %s\n", a1, b1, a1.minus(b1));
        System.out.printf("%s - %s: %s\n", b1, a1, b1.minus(a1));
        System.out.printf("%s * %s: %s\n", a1, b1, a1.times(b1));
        System.out.printf("%s * %s: %s\n", b1, a1, b1.times(a1));
        System.out.printf("%s / %s: %s\n", a1, b1, a1.divides(b1));
        System.out.printf("%s / %s: %s\n", b1, a1, b1.divides(a1));
        a1 = new Rational(-5, 3);
        b1 = new Rational(-2, 3);
        System.out.printf("%s + %s: %s\n", a1, b1, a1.plus(b1));
        System.out.printf("%s + %s: %s\n", b1, a1, b1.plus(a1));
        System.out.printf("%s - %s: %s\n", a1, b1, a1.minus(b1));
        System.out.printf("%s - %s: %s\n", b1, a1, b1.minus(a1));
        System.out.printf("%s * %s: %s\n", a1, b1, a1.times(b1));
        System.out.printf("%s * %s: %s\n", b1, a1, b1.times(a1));
        System.out.printf("%s / %s: %s\n", a1, b1, a1.divides(b1));
        System.out.printf("%s / %s: %s\n", b1, a1, b1.divides(a1));
    }
}
