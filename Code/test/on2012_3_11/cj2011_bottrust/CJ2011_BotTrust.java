package on2012_3_11.cj2011_bottrust;



import java.util.Scanner;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CJ2011_BotTrust {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        //int tc = in.nextInt();
        //in.nextLine();
        int pressCount, totalElapsedSeconds, lastCycleCount, moveCount;
        int bluePos, orangePos, currentPos;
        String line;
        char lastRobot, currentRobot;
        StringTokenizer tokens;

        //for(int tci = 1; tci <= tc; tci++) {
            pressCount = in.nextInt();
            line = in.nextLine();
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
            out.println("Case #" + testNumber + ": " + totalElapsedSeconds);
        //}
    }
}
