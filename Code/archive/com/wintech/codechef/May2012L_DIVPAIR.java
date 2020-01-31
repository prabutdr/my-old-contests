package com.wintech.codechef;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class May2012L_DIVPAIR {
    long N, M;
    long count;
    double tempSum;
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        N = in.readInt();
        M = in.readInt();

        count = ((N * (N + 1)) / (2 * M));
        //out.println("count - 1: " + count);
        //tempSum = (((double)M * (M - 1)) / (2 * M));
        //out.println("tempSum - 1: " + tempSum);
        //out.println("N/M: " + (N/M) * (M - 1)/2.0);
        count = (long)(count - ((N/M) * (M - 1)/2.0));
        //out.println("count - 2: " + count);
        /*long M1 = N % M;
        if(M > 0) {
            tempSum = ((M1 * (M1 + 1)) / (2 * M));
            count = count - tempSum;
        }*/

        out.println(count);


//        //out.println(((N * (N + 1)) / (2 * M)));
//        out.println((((N * (N + 1)) / (2 * M))) - ((N / M) / M));
//
////        else {
//            count = 0;
//            for(int i = 1; i <= 1000000000; i++) {
//                for(int j = i+1; j <= 1000000000; j++) {
//                    if((i+j) % 5 == 0) {
//                        //out.println(i + ", " + j + " " + (i+j));
//                        count++;
//                    }
//                }
//            }
//            out.println("Count: " + count);
////
////            count = 0;
////            for(int i = 1; i <= N; i++) {
////                count += ((N - i + 1) / M);
////            }
////            out.println(count);
////        }

        if(N < M) {
            out.println((N + (N - 1)) / M);
        }
        else {
            count = 0;
            for(int i = 1; i <= N; i++) {
                //count += i / M;
                count += ((N - i + 1) / M);
            }
            out.println(count);
        }
    }
}
