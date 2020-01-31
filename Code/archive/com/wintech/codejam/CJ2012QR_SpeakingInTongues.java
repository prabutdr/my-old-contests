package com.wintech.codejam;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CJ2012QR_SpeakingInTongues {
    public static char[] googleressMap;

    public CJ2012QR_SpeakingInTongues() {
        googleressMap = new char[26];
        String googleressStr = "ejp mysljylc kd kxveddknmc re jsicpdrysi rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd de kr kd eoya kw aej tysr re ujdr lkgc jv";
        String englishStr = "our language is impossible to understand there are twenty six factorial possibilities so it is okay if you want to just give up";
        int idx;
        googleressMap['z' - 'a'] = 'q';
        googleressMap['q' - 'a'] = 'z';
        for(int i = 0; i < 26; i++) {
            idx = googleressStr.indexOf('a' + i);
            if(idx != -1) {
                googleressMap[i] = englishStr.charAt(idx);
            }
        }
        //System.out.println(Arrays.toString(googleressMap));
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        if(testNumber == 1)
            in.nextLine();
        StringBuilder sb = new StringBuilder(in.nextLine());
        for(int i = 0; i < sb.length(); i++) {
            if(!Character.isSpaceChar(sb.charAt(i))) {
                sb.setCharAt(i, googleressMap[sb.charAt(i) - 'a']);
            }
        }
        out.printf("Case #%d: %s\n", testNumber, sb.toString());
	}
}
