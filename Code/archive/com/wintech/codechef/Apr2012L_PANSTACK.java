package com.wintech.codechef;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;

public class Apr2012L_PANSTACK {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        int ii = 1;
        int count = 0;
        int loop1, loop2, loop3, loop4;
        loop1 = loop2 = 0;
        for(int i = 1; i <= 3 && (i - ii) <= 1; i++, loop1++) {
            for(int j = 1; j <= 3 && ((j - ii) <= 1 || (j - i) <= 1); j++, loop2++) {
                    System.out.println(ii + "" + i + "" + j);
                    count++;
            }
        }
        System.out.println("Count - 3: " + count);
        System.out.println("loop - 1: " + loop1);
        System.out.println("loop - 2: " + loop2);
        count = 0;
        loop1 = loop2 = loop3 = 0;
        for(int i = 1; i <= 4 && (i - ii) <= 1; i++, loop1++) {
            for(int j = 1; j <= 4 && ((j - ii) <= 1 || (j - i) <= 1); j++, loop2++) {
                for(int k = 1; k <=4 && ((k - ii) <= 1 || (k - i) <= 1 || (k - j) <= 1); k++, loop3++) {
                    System.out.println(ii + "" + i + "" + j + "" + k);
                    count++;
                }
            }
        }
        System.out.println("Count - 4: " + count);
        System.out.println("loop - 1: " + loop1);
        System.out.println("loop - 2: " + loop2);
        System.out.println("loop - 3: " + loop3);
        count = 0;
        loop1 = loop2 = loop3 = loop4 = 0;
        for(int i = 1; i <= 5 && (i - ii) <= 1; i++, loop1++) {
            for(int j = 1; j <= 5 && ((j - ii) <= 1 || (j - i) <= 1); j++, loop2++) {
                for(int k = 1; k <= 5 && ((k - ii) <= 1 || (k - i) <= 1 || (k - j) <= 1); k++, loop3++) {
                    for(int m = 1; m <= 5 && ((m - ii) <= 1 || (m - i) <= 1 || (m - j) <= 1 || (m - k) <= 1); m++, loop4++) {
                        System.out.println(ii + "" + i + "" + j + "" + k + "" + m);
                        count++;
                    }
                }
            }
        }
        System.out.println("Count - 5: " + count);
        System.out.println("loop - 1: " + loop1);
        System.out.println("loop - 2: " + loop2);
        System.out.println("loop - 3: " + loop3);
        System.out.println("loop - 4: " + loop4);
    }
}
