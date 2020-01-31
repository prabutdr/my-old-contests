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

    final static String FILENAME = "C-small-practice";
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
        int i;
        TreeSet<Card> handset;
        ArrayList<Card> drawset;

        for(int tci = 1; tci <= tc; tci++) {
            int handCount = sc.nextInt();
            handset = new TreeSet<Card>();
            for(i = 0; i < handCount; i++) {
                Card c = new Card(sc.nextInt(), sc.nextInt(), sc.nextInt());
                handset.add(c);
            }

            int drawCount = sc.nextInt();
            drawset = new ArrayList<Card>();
            for(i = 0; i < drawCount; i++) {
                Card c = new Card(sc.nextInt(), sc.nextInt(), sc.nextInt());
                drawset.add(c);
            }

            int t = 1, s = 0;
            while(t >= 1 && !handset.isEmpty()) {
                t--;
                Card c = handset.pollFirst();
                t += c.t;
                s += c.s;
                int k = (c.c < drawset.size())?c.c:drawset.size();
                for(i = 0; i < k; i++) {
                    handset.add(drawset.remove(0));
                }
            }
            out.println("Case #" + tci + ": " + s);
        }
    }
/******************************************************************************/
}

class Card implements Comparable<Card>{
    public int c, s, t;

    Card(int c, int s, int t) {
        this.c = c;
        this.s = s;
        this.t = t;
    }

    @Override
    public String toString() {
        return c + "-" + s + "-" + t;
    }

    public int compareTo(Card o) {
        String tstr = t + "," + s + "," + c;
        String ostr = o.t + "," + o.s + "," + o.c;
        return ostr.compareTo(tstr);
    }
}