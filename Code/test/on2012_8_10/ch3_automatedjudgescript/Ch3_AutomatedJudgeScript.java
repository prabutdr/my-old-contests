package on2012_8_10.ch3_automatedjudgescript;



import com.wintech.io.BaseIn;
import java.io.PrintWriter;

public class Ch3_AutomatedJudgeScript {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        int i, j;

        int n = in.readInt();
        if(n == 0)
            System.exit(0);

        StringBuilder correctOutput = new StringBuilder();
        for(i = 0; i < n; i++) {
            correctOutput.append(in.readLine());
        }

        int m = in.readInt();
        StringBuilder submittedOutput = new StringBuilder();
        for(i = 0; i < m; i++) {
            submittedOutput.append(in.readLine());
        }
    }
}
