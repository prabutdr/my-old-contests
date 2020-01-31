/*
 * To change this C_CandySplit, choose Tools | C_CandySplits
 * and open the C_CandySplit in the editor.
 */

/**
 * @date 07-May-2011
 * @author Prabu
 */

import java.io.*;
import java.util.*;

public class C_CandySplit {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            C_CandySplit solver = new C_CandySplit();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "C-large";
    private static Scanner sc;
    private static PrintWriter out;

    void openIO() throws IOException {
        String inFileName = "IO/Input/" + FILENAME + ".IN";
        String outFileName = "IO/Output/" + FILENAME + ".OUT";

        sc = new Scanner(new File(inFileName));
        out = new PrintWriter(new File(outFileName));
    }

    void closeIO() throws IOException {
        out.close();
        sc.close();
    }

/******************************************************************************/
    void solve() throws IOException {
        int tc = sc.nextInt();
        long n, i, c, min, total, xcomp;
        for(int tci = 1; tci <= tc; tci++) {
            n = sc.nextInt();

            c = sc.nextInt(); // Read first value
            xcomp = min = total = c;

            for(i = 1; i < n; i++) {
                c = sc.nextInt();
                total += c;
                if(min > c)
                    min = c;
                xcomp ^= c;
            }

            if(xcomp == 0)
                out.println("Case #" + tci + ": " + (total - min));
            else
                out.println("Case #" + tci + ": NO");
        }
    }
/******************************************************************************/
}
