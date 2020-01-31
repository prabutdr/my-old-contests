package com.wintech.poj;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class POJ1176_PartyLamps {
    final static boolean ON = true;
    final static boolean OFF = false;
    final boolean[][] possible = {
            //Even  Even(3k+1)  Odd     Odd(3k+1)
            {ON,    ON,         ON,     ON},  // All on
            {OFF,   OFF,        OFF,    OFF}, // All off
            {ON,    ON,         OFF,    OFF}, // Only Even
            {OFF,   OFF,        ON,     ON},  // Only Odd
            {ON,    OFF,        ON,     OFF}, // 3k+1 off
            {OFF,   ON,         OFF,    ON},  // Only 3k+1
            {ON,    OFF,        OFF,    ON},  // Even & odd 3k+1 on
            {OFF,   ON,         ON,     OFF}  // Odd & Even 3k+1 on
    };

    public void solve(int testNumber, BaseIn in, PrintWriter out) {
        int n = in.readInt();
        int c = in.readInt();
        ArrayList<Integer> final_on = new ArrayList<Integer>();
        ArrayList<Integer> final_off = new ArrayList<Integer>();
        boolean[] pos_result;
        ArrayList<String> result = new ArrayList<String>();

        int number = in.readInt();
        while(number != -1) {
            final_on.add(number);
            number = in.readInt();
        }
        number = in.readInt();
        while(number != -1) {
            final_off.add(number);
            number = in.readInt();
        }

        int k;
        outer:
        for(int i = 0; i < possible.length; i++) {
            if(c == 1 && (i == 0 || i == 5 || i == 6 || i == 7))
                continue;
            else if(c == 2 && (i == 4))
                continue;

            pos_result = new boolean[n+1];
            for(int j = 0; j < possible[i].length; j++) {
                switch(j) {
                    case 0:
                        for(k = 2; k <= n; k+=2) {
                            pos_result[k] = possible[i][j];
                        }
                        break;
                    case 1:
                        for(k = 4; k <= n; k+=6) {
                            pos_result[k] = possible[i][j];
                        }
                        break;
                    case 2:
                        for(k = 1; k <= n; k+=2) {
                            pos_result[k] = possible[i][j];
                        }
                        break;
                    case 3:
                        for(k = 1; k <= n; k+=6) {
                            pos_result[k] = possible[i][j];
                        }
                        break;
                }
            }

            for(int element: final_on) {
                if(pos_result[element] == OFF)
                    continue outer;
            }

            for(int element: final_off) {
                if(pos_result[element] == ON)
                    continue outer;
            }

            result.add(toString(pos_result));
        }

        Collections.sort(result);
        for(String element: result) {
            out.println(element);
        }
    }

    private String toString(boolean[] a) {
        StringBuilder sb = new StringBuilder(a.length);
        for(int i = 1; i < a.length; i++) {
            if(a[i] == ON)
                sb.append("1");
            else
                sb.append("0");
        }
        return sb.toString();
    }
}
