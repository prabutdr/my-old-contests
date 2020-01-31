import java.io.*;
import java.util.*;

public class Problem_B {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            Problem_B solver = new Problem_B();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "B-small-attempt";
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
        int c, d, i, j;
        double[] p;
        int[] v;
        double sec, cursec;
        for(int tci = 1; tci <= tc; tci++) {
            c = sc.nextInt();
            d = sc.nextInt();
            p = new double[c];
            v = new int[c];
            for(i = 0; i < c; i++) {
                p[i] = sc.nextInt();
                v[i] = sc.nextInt();
            }
            //System.out.println(Arrays.toString(p));
            //System.out.println(Arrays.toString(v));

            sec = 0;
            for(i = 0; i < c; i++) {
                cursec = 0;
                if(v[i] != 1) {
                    cursec = (v[i] - 1) * d / 2.0;
                    if(cursec != 0) {
                        sec += cursec;
                        for(j = i; j < c; j++) {
                            p[j] += cursec;
                        }
                    }
                }

                if(i != 0 && p[i] - p[i-1] < d) {
                    cursec = (d - (p[i] - p[i-1])) / 2.0;
                    //System.out.println(cursec + " " + p[i] + " " + p[i - 1] + " " + (p[i] - p[i-1]));
                    if(cursec != 0) {
                        sec += cursec;
                        for(j = i+1; j < c; j++) {
                            p[i] += cursec;
                        }
                    }
                }
            }
            out.println("Case #" + tci + ": " + sec);
        }
    }
/******************************************************************************/
}
