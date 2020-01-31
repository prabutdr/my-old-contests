/*
 * To change this D_GoroSoft, choose Tools | D_GoroSofts
 * and open the D_GoroSoft in the editor.
 */

/**
 * @date 07-May-2011
 * @author Prabu
 */

import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Problem_D {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            Problem_D solver = new Problem_D();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "D-small-attempt";
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
        for(int tci = 1; tci <= tc; tci++) {
            //System.out.printf("Case #%d: %.6f\n", tci, (moveCount * 2.0));
        }
    }
/******************************************************************************/
}
