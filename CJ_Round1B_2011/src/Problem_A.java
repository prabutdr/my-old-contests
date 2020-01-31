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

        int gridsize, i, j;
        char[][] grid;
        String line;
        double[] wp, owp, oowp;
        double totalOpponent, totalOWP;
        double rpi;
        for(int tci = 1; tci <= tc; tci++) {
            gridsize = sc.nextInt();
            sc.nextLine();
            grid = new char[gridsize][];
            wp = new double[gridsize];
            owp = new double[gridsize];
            oowp = new double[gridsize];
            for(i = 0; i < gridsize; i++) {
                line = sc.nextLine();
                grid[i] = line.toCharArray();
                //System.out.println(Arrays.toString(grid[i]));
            }

            for(i = 0; i < gridsize; i++) {
                wp[i] = calculateWP(grid[i], -1);
                totalOpponent = 0;
                totalOWP = 0;
                for(j = 0; j < gridsize; j++) {
                    if(grid[i][j] == '.')
                        continue;
                    totalOpponent++;
                    totalOWP += calculateWP(grid[j], i);
                }
                owp[i] = totalOWP / totalOpponent;
                /*totalPlayed = 0;
                totalWin = 0;
                for(j = 0; j < gridsize; j++) {
                    if(grid[i][j] == '.')
                        continue;
                    totalPlayed++;
                    if(grid[i][j] == '1')
                        totalWin++;
                }
                wp[i] = totalWin / totalPlayed;*/
            }

            out.println("Case #" + tci + ":");
            for(i = 0; i < gridsize; i++) {
                totalOpponent = 0;
                totalOWP = 0;
                for(j = 0; j < gridsize; j++) {
                    if(grid[i][j] == '.')
                        continue;
                    totalOpponent++;
                    totalOWP += owp[j];
                }
                oowp[i] = totalOWP / totalOpponent;
                //out.printf("%e\n", 0.25 * wp[i] + 0.50 * owp[i] + 0.25 * oowp[i]);
                out.println(0.25 * wp[i] + 0.50 * owp[i] + 0.25 * oowp[i]);
            }
            //System.out.println(Arrays.toString(wp));
            //System.out.println(Arrays.toString(owp));
            //System.out.println(Arrays.toString(oowp));
        }

    }

    private double calculateWP(char[] schedule, int excIdx) {
        int i;
        double totalPlayed, totalWin;
        totalPlayed = 0;
        totalWin = 0;
        for(i = 0; i < schedule.length; i++) {
            if(schedule[i] == '.' || excIdx == i)
                continue;
            totalPlayed++;
            if(schedule[i] == '1')
                totalWin++;
        }
        return totalWin / totalPlayed;
    }
/******************************************************************************/
}

