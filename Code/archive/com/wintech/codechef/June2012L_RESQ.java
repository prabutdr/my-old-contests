package com.wintech.codechef;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;

// Accepted
public class June2012L_RESQ {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        int N = in.readInt();

        int base = (int)Math.sqrt(N);
        for(; base > 0; base--) {
            if(N%base == 0) {
                out.println((N/base) - base);
                break;
            }
        }
	}
}
