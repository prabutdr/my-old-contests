package on2012_8_10.ch2_stackemup;



import com.wintech.io.BaseIn;
import net.egork.chelper.task.Test;
import net.egork.chelper.tester.Verdict;

import java.util.Collection;
import java.util.Collections;

public class Ch2_StackEmUpChecker {
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
