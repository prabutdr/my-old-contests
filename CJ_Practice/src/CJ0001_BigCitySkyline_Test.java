/**
 * To generate input test file for CJ0001_BigCitySkyline
 *
 * @author Prabu
 * @date 12-Apr-2011
 */

import java.io.*;
import java.util.*;

public class CJ0001_BigCitySkyline_Test {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            CJ0001_BigCitySkyline_Test solver = new CJ0001_BigCitySkyline_Test();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "CJ0001_BigCitySkyline_Test";
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
            int seed = sc.nextInt();
            Random random = new Random(seed);
            int numberOfBuildings = sc.nextInt();

            out.print(numberOfBuildings);
            for(int i = 0; i < numberOfBuildings; i++)
                out.print(" " + random.nextInt(seed) + " " + random.nextInt(seed));
            out.println();
        }
    }
/******************************************************************************/
}
