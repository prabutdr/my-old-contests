package com.wintech.poj;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ch3_WERTYU {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        String keyboard = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

        int ch;
        int idx;
        while(true) {
            ch = in.read();
            if(ch == -1)
                break;

            idx = keyboard.indexOf(ch);
            if(idx == -1) {
                out.print((char)ch);
            }
            else {
                out.print(keyboard.charAt(idx - 1));
            }
        }
	}
}
