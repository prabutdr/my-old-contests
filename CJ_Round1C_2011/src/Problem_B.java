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
        long l, t, n;
        int c, i;
        int[] a, ac;
        long cycleLength, cycleCount, compCycle, carry;

        for(int tci = 1; tci <= tc; tci++) {
            l = sc.nextLong();
            t = sc.nextLong();
            n = sc.nextLong();
            c = sc.nextInt();
            a = new int[c];
            ac = new int[c];

            cycleCount = n / c;
            cycleLength = 0;
            for(i = 0; i < c; i++) {
                a[i] = sc.nextInt();
                cycleLength += a[i];
            }
            cycleLength *= 2;
            System.arraycopy(a, 0, ac, 0, c);
            Arrays.sort(ac);
            System.out.println(l + " " + t + " " + n + " " + c + " " + Arrays.toString(a)
                    + " " + cycleCount + " " + cycleLength);
            System.out.println(Arrays.toString(ac));

            compCycle = t / cycleLength;
            carry = t % cycleLength;
            System.out.println(compCycle + " " + carry);

            //out.println("Case #" + tci + ": " + elements);
        }
    }
/******************************************************************************/
}
