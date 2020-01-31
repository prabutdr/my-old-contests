package com.wintech.codechef;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.Arrays;

public class Jun2012L_LUCKY8_1 {
    public void solve(int testNumber, BaseIn in, PrintWriter out) {
        int max = 0, tmax;
        long l = in.readLong();
        String R = in.readString();
        String temp;

        int length = R.length();
        String format = "%0" + length + "d";
        char[] array = new char[length];

        String L = String.format(format, l);
        char[] larray = L.toCharArray();

        int ceilVal = (int)Math.ceil(length / 2.0);
        for(int i = (int)Math.floor(length / 2.0); i >= 0; i--) {
            for(int j = length-i; j >= 0; j--) {
                //if(max >= (i * j))
                //    continue;
                //char ch = '0';
                //do {
                out.println(i + " " + j + " " + length);
                //Arrays.fill(array, ch);
                System.arraycopy(larray, 0, array, 0, length);
                Arrays.fill(array, length - i, length, '7');
                Arrays.fill(array, length - j - i, length - i, '4');
                temp = String.valueOf(array);
                out.println(L + " " + R + " " + temp + " " + (L.compareTo(temp) <= 0 && R.compareTo(temp) >= 0));
                if(L.compareTo(temp) <= 0 && R.compareTo(temp) >= 0) {
                    //max = i*j;
                    //continue;
                    tmax = getCount(array);
                    if(tmax > max)
                        max = tmax;
                }

                //Arrays.fill(array, ch);
                System.arraycopy(larray, 0, array, 0, length);
                Arrays.fill(array, length - i, length, '4');
                Arrays.fill(array, length - j - i, length - i, '7');
                temp = String.valueOf(array);
                out.println(L + " " + R + " " + temp + " " + (L.compareTo(temp) <= 0 && R.compareTo(temp) >= 0));
                if(L.compareTo(temp) <= 0 && R.compareTo(temp) >= 0) {
                    //max = i*j;
                    //continue;
                    tmax = getCount(array);
                    if(tmax > max)
                        max = tmax;
                }

                //Arrays.fill(array, ch);
                System.arraycopy(larray, 0, array, 0, length);
                Arrays.fill(array, 0, i, '7');
                Arrays.fill(array, i, i+j, '4');
                temp = String.valueOf(array);
                out.println(L + " " + R + " " + temp + " " + (L.compareTo(temp) <= 0 && R.compareTo(temp) >= 0));
                if(L.compareTo(temp) <= 0 && R.compareTo(temp) >= 0) {
                    //max = i*j;
                    //continue;
                    tmax = getCount(array);
                    if(tmax > max)
                        max = tmax;
                }

                //Arrays.fill(array, ch);
                System.arraycopy(larray, 0, array, 0, length);
                Arrays.fill(array, 0, i, '4');
                Arrays.fill(array, i, i+j, '7');
                temp = String.valueOf(array);
                out.println(L + " " + R + " " + temp + " " + (L.compareTo(temp) <= 0 && R.compareTo(temp) >= 0));
                if(L.compareTo(temp) <= 0 && R.compareTo(temp) >= 0) {
                    //max = i*j;
                    //continue;
                    tmax = getCount(array);
                    if(tmax > max)
                        max = tmax;
                }
                //ch++;
                //} while(ch <= '9' && j < ceilVal);
            }
        }

        //if(max == 0) {
        int fourCount = 0, sevenCount = 0;
        for(char ch: L.toCharArray()) {
            if(ch == '4') {
                fourCount++;
                continue;
            }
            if(ch == '7') {
                sevenCount++;
                continue;
            }
        }
        if(max < fourCount * sevenCount)
            max = fourCount * sevenCount;
        fourCount = 0; sevenCount = 0;
        for(char ch: R.toCharArray()) {
            if(ch == '4') {
                fourCount++;
                continue;
            }
            if(ch == '7') {
                sevenCount++;
                continue;
            }
        }
        if(max < fourCount * sevenCount)
            max = fourCount * sevenCount;
        //}

        out.println(max);
    }

    private int getCount(char[] array) {
        int fourCount = 0, sevenCount = 0;
        for(char ch: array) {
            if(ch == '4') {
                fourCount++;
                continue;
            }
            if(ch == '7') {
                sevenCount++;
                continue;
            }
        }
        return fourCount * sevenCount;
    }
}
