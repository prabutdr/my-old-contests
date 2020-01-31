package com.wintech.codechef;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;

public class May2012L_STONES {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        if(testNumber == 1)
            in.readLine();
        String J = in.readLine();
        StringBuilder S = new StringBuilder(in.readLine());
        //out.println("J: " + J);
        //out.println("S: " + S);

        int i, j, count = 0, idx;
        String ch;
        for(i = 0; i < J.length(); i++) {
            ch = String.valueOf(J.charAt(i));
            for(j = 0; j < S.length(); j++) {
                idx = S.indexOf(ch);
                if(idx != -1) {
                    count++;
                    S.deleteCharAt(idx);
                }
            }
        }

        out.println(count);
    }
}
