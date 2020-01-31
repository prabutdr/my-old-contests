package com.wintech.codejam;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CJ2014QR_MagicTrick {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        final int SIZE = 4;

        int answer1 = in.readInt();
        int[] cardArrangement11 = in.readInt2D(SIZE, SIZE)[answer1-1];
        ArrayList<Integer> cardArrangement12 = new ArrayList<Integer>();
        ArrayList<Integer> cardArrangement13 = new ArrayList<Integer>();
        for(int i = 0; i < SIZE; i++) {
            cardArrangement12.add(cardArrangement11[i]);
            cardArrangement13.add(cardArrangement11[i]);
        }

        int answer2 = in.readInt();
        int[] cardArrangement21 = in.readInt2D(SIZE, SIZE)[answer2-1];
        ArrayList<Integer> cardArrangement22 = new ArrayList<Integer>();
        for(int i = 0; i < SIZE; i++) {
            cardArrangement22.add(cardArrangement21[i]);
        }

        cardArrangement12.removeAll(cardArrangement22);

        if(cardArrangement12.size() == SIZE) {
            out.println("Case #" + testNumber + ": " + "Volunteer cheated!");
        }
        else if(cardArrangement12.size() == SIZE-1) {
            cardArrangement13.removeAll(cardArrangement12);
            out.println("Case #" + testNumber + ": " + cardArrangement13.get(0));
        }
        else {
            out.println("Case #" + testNumber + ": " + "Bad magician!");
        }
	}
}
