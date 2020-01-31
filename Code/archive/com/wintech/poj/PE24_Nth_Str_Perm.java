package com.wintech.poj;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.Arrays;

public class PE24_Nth_Str_Perm {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        char[] str = in.readLine().toCharArray();
        char temp;
        int n = in.readInt();
        Arrays.sort(str);

        while(n > 1) {
            int i, j, fact = 1;
            for(i = 2; ; i++) {
                fact *= i;
                if(fact >= n) {
                    fact /= i;
                    break;
                }
            }

            n = n - fact;
            if(fact == 1)
                j = 1;
            else
                j = ((n-1) / fact) + 1;
            if(n > fact) {
                n = (n % fact);
                if(n == 0)
                    n = fact;
            }

            i = str.length - i;
            j = i + j;

            temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            Arrays.sort(str, i+1, j+1);
        }

        out.printf("Case #%d: %s\n", testNumber, String.valueOf(str));
    }
}
