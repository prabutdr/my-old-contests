/*
 * To change this A_BotTrust, choose Tools | A_BotTrusts
 * and open the A_BotTrust in the editor.
 */

/**
 * @date 06-May-2011
 * @author Prabu
 */

import java.io.*;
import java.util.*;

public class A_BotTrust {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            A_BotTrust solver = new A_BotTrust();
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
        sc.nextLine();
        int pressCount, totalElapsedSeconds, lastCycleCount, moveCount;
        int bluePos, orangePos, currentPos;
        String line;
        char lastRobot, currentRobot;
        StringTokenizer tokens;

        for(int tci = 1; tci <= tc; tci++) {
            pressCount = sc.nextInt();
            line = sc.nextLine();
            tokens = new StringTokenizer(line, " ");
            
            bluePos = orangePos = 1;
            totalElapsedSeconds = 0;
            lastCycleCount = 0;
            lastRobot = '\0';
            for(int i = 0; i < pressCount; i++) {
                currentRobot = tokens.nextToken().charAt(0);
                currentPos = Integer.parseInt(tokens.nextToken());

                if(currentRobot == 'O') {
                    moveCount = Math.abs(orangePos - currentPos);
                    orangePos = currentPos;
                }
                else {
                    moveCount = Math.abs(bluePos - currentPos);
                    bluePos = currentPos;
                }

                if(currentRobot == lastRobot) {
                    moveCount++; //plus click
                }
                else {
                    moveCount = moveCount - lastCycleCount;
                    if(moveCount <= 0)
                        moveCount = 1;
                    else
                        moveCount++;

                    lastCycleCount = 0;
                }

                totalElapsedSeconds += moveCount;
                lastCycleCount += moveCount;
                lastRobot = currentRobot;
            }
            out.println("Case #" + tci + ": " + totalElapsedSeconds);
        }
    }
/******************************************************************************/
}

