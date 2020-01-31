package com.wintech.poj;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;

public class CE_RepeatedSubstring {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        char[] array = in.readLine().toCharArray();
        String result = "", tmpResult;
        int i, j, firstIdx, secondIdx;

        for(firstIdx = 0; ; firstIdx++) {
            secondIdx = array.length - 1 - result.length();

            if((secondIdx - firstIdx) <= result.length())
                break;

            do {
                for(i = firstIdx, j = secondIdx; i < secondIdx && j < array.length; i++, j++) {
                    if(array[i] != array[j]) {
                        break;
                    }
                }
                tmpResult = String.valueOf(array, firstIdx, i - firstIdx);
                if(tmpResult.trim().length() > result.length()) {
                    result = tmpResult;
                }
                secondIdx--;
            } while ((secondIdx - firstIdx) > result.length());
        }

        if(result.length() == 0)
            out.println("NONE");
        else
            out.println(result + " " + result.length());
	}
}
