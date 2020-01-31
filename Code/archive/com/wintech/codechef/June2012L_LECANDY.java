package com.wintech.codechef;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;

//Accepted
public class June2012L_LECANDY {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        int N = in.readInt();
        int C = in.readInt();

        for(; N > 0 && C >= 0; N--) {
            C -= in.readInt();
        }
        for(; N > 0; N--) {
            in.readInt();
        }

        if(C >= 0) {
            out.println("Yes");
        }
        else {
            out.println("No");
        }
	}
}
