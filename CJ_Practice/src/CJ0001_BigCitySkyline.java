/**
 * Google Code Jam Practice Problems - 2008 - A
 * 
 * @author Prabu
 * @date 12-Apr-2011
 */

import java.io.*;
import java.util.*;

public class CJ0001_BigCitySkyline {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            CJ0001_BigCitySkyline solver = new CJ0001_BigCitySkyline();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "CJ0001_BigCitySkyline";
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
            int numberOfBuildings = sc.nextInt();
            int[] width = new int[numberOfBuildings];
            int[] height = new int[numberOfBuildings];
            int i, j;

            for(i = 0; i < numberOfBuildings; i++) {
                width[i] = sc.nextInt();
                height[i] = sc.nextInt();
            }

            int maxArea = 0, lastWidth, lastHeight, tmpArea;
            for(i = 0; i < numberOfBuildings; i++) {
                lastWidth = width[i];
                lastHeight = height[i];
                tmpArea = lastWidth * lastHeight;
                if(tmpArea > maxArea)
                    maxArea = tmpArea;
                for(j = i + 1; j < numberOfBuildings; j++) {
                    lastWidth += width[j];
                    if(lastHeight > height[j])
                        lastHeight = height[j];
                    else if(height[j] == 0)
                        lastWidth = 0;
                    tmpArea = lastWidth * lastHeight;
                    if(tmpArea > maxArea)
                        maxArea = tmpArea;
                }
            }

            out.println("Case #" + tci + ": " + maxArea);
        }
    }
/******************************************************************************/
}
