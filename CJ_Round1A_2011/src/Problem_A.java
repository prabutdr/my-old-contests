import java.io.*;
import java.util.*;

public class Problem_A {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            Problem_A solver = new Problem_A();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "A-large";
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
        long n, pd, pg, pr;

        for(int tci = 1; tci <= tc; tci++) {
            n = sc.nextLong();
            pd = sc.nextLong();
            pg = sc.nextLong();

            if(pg == 100 && pd != 100) {
                out.println("Case #" + tci + ": Broken");
                continue;
            }
            if(pg == 0 && pd != 0) {
                out.println("Case #" + tci + ": Broken");
                continue;
            }

            pr = 100 - pd;
            for(int i = 2; i <= 50; ) {
                if(pr%i == 0 && pd%i == 0) {
                    pr /= i;
                    pd /= i;
                    continue;
                }
                i++;
            }
            if((pr + pd) <= n)
                out.println("Case #" + tci + ": Possible");
            else
                out.println("Case #" + tci + ": Broken");
            //out.println("Case #" + tci + ": " + totalElapsedSeconds);
        }
    }
/******************************************************************************/
}

