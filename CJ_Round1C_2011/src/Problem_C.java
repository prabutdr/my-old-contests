import java.io.*;
import java.util.*;

public class Problem_C {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            Problem_C solver = new Problem_C();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "C-small-attempt";
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
            //out.println("Case #" + tci + ": " + s);
        }
    }
/******************************************************************************/
}
