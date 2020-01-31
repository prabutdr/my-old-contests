package on2014_3_12.c2a_winner;



import com.wintech.io.BaseIn;
import net.egork.chelper.task.Test;
import net.egork.chelper.tester.Verdict;

import java.util.Collection;
import java.util.Collections;

public class C2A_WinnerChecker {
	public Verdict check(BaseIn input, BaseIn expected, BaseIn actual) {
		return Verdict.UNDECIDED;
	}

	public double getCertainty() {
		return 0;
	}

	public Collection<? extends Test> generateTests() {
		return Collections.emptyList();
	}
}
