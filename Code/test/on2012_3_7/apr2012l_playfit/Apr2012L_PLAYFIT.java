package on2012_3_7.apr2012l_playfit;



import com.wintech.io.BaseIn;
import java.io.PrintWriter;

public class Apr2012L_PLAYFIT {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        int N = in.readInt();
        int goalDiff = 0, curGoal, curGoalDiff;
        int minGoal = in.readInt(); // first game goal
        for(int i = 2; i <= N; i++) {
            curGoal = in.readInt();
            curGoalDiff = curGoal - minGoal;
            if(minGoal < curGoal && goalDiff < curGoalDiff) {
                goalDiff = curGoalDiff;
            }
            else if(minGoal > curGoal) {
                minGoal = curGoal;
            }
        }
        if(goalDiff == 0) {
            out.println("UNFIT");
        }
        else {
            out.println(goalDiff);
        }
	}
}
