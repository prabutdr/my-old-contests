package on2012_8_10.ch2_contestscoreboard;



import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Ch2_ContestScoreboard {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        if(testNumber == 1) {
            in.readLine();
            in.readLine();
        }
        else
            out.println();

        int contestantNbr, problemNbr, minElapsed;
        String line, result;
        String[] tokens;
        HashMap<Integer, ScoreItem> scoreboard = new HashMap<Integer, ScoreItem>();
        while (!in.isEOF()) {
            line = in.readLine();
            //out.println("line: " + line);
            if(line.length() == 0)
                break; // complete this case if blank line found

            tokens = line.split(" ");
            //System.out.println("Line: " + Arrays.toString(tokens));
            contestantNbr = Integer.parseInt(tokens[0]);
            problemNbr = Integer.parseInt(tokens[1]) - 1;
            minElapsed = Integer.parseInt(tokens[2]);
            result = tokens[3];

            ScoreItem curItem;
            if(scoreboard.containsKey(contestantNbr)) {
                curItem = scoreboard.get(contestantNbr);
            }
            else {
                curItem = new ScoreItem(contestantNbr);
                scoreboard.put(contestantNbr, curItem);
            }

            if(curItem.attemptCnt[problemNbr] != ScoreItem.STATUS_SOLVED) {
                if("I".equalsIgnoreCase(result)) {
                    curItem.attemptCnt[problemNbr]++;
                }
                else if("C".equalsIgnoreCase(result)) {
                    curItem.penalty += (minElapsed + (curItem.attemptCnt[problemNbr] * 20));
                    curItem.attemptCnt[problemNbr] = ScoreItem.STATUS_SOLVED;
                    curItem.solvedCnt++;
                }
            }
        }

        TreeSet<ScoreItem> set = new TreeSet(scoreboard.values());
        for(ScoreItem item: set) {
            out.println(item);
        }
	}
}

class ScoreItem implements Comparable<ScoreItem> {
    public static final int PROBLEM_COUNT = 9;
    public static final int STATUS_SOLVED = -1;

    int contestantNumber;
    int[] attemptCnt;
    int penalty;
    int solvedCnt;

    ScoreItem(int contestantNumber) {
        this.contestantNumber = contestantNumber;
        attemptCnt = new int[PROBLEM_COUNT];
        penalty = 0;
        solvedCnt = 0;
    }

    public int getNumberOfProblemsSolved() {
        int result = 0;
        for(int i = 0; i < PROBLEM_COUNT; i++) {
            if(attemptCnt[i] == STATUS_SOLVED)
                result++;
        }
        return result;
    }

    @Override
    public String toString() {
        return contestantNumber + " " + solvedCnt + " " + penalty;
    }

    @Override
    public int compareTo(ScoreItem that) {
        if(this.solvedCnt != that.solvedCnt)
            return that.solvedCnt - this.solvedCnt;

        if(this.penalty != that.penalty)
            return this.penalty - that.penalty;

        return this.contestantNumber - that.contestantNumber;
    }
}
