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

        int row, col, i, j;
        char[][] grid;
        String line;
        for(int tci = 1; tci <= tc; tci++) {
            row = sc.nextInt();
            col = sc.nextInt(); sc.nextLine();
            grid = new char[row][];
            for(i = 0; i < row; i++) {
                line = sc.nextLine();
                grid[i] = line.toCharArray();
                //System.out.println(Arrays.toString(grid[i]));
            }

            outer:
            for(i = 0, j=0; i < row; i++) {
                for(j = 0; j < col; j++) {
                    if(grid[i][j] == '#') {
                        if(i+1 < row && j+1 < col && grid[i][j+1] == '#'
                                && grid[i+1][j] == '#' && grid[i+1][j+1] == '#') {
                            grid[i][j] = '/';
                            grid[i][j+1] = '\\';
                            grid[i+1][j] = '\\';
                            grid[i+1][j+1] = '/';
                        }
                        else {
                            break outer;
                        }
                    }
                }
            }
            out.println("Case #" + tci + ":");
            if(i == row && j == col) {
                for(i = 0; i < row; i++) {
                    for(j = 0; j < col; j++) {
                        out.print(grid[i][j]);
                    }
                    out.println();
                }
            }
            else {
                out.println("Impossible");
            }
        }
    }
/******************************************************************************/
}

