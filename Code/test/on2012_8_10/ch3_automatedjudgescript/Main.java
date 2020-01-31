package on2012_8_10.ch3_automatedjudgescript;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.ch3_automatedjudgescript.Ch3_AutomatedJudgeScript",
			"MULTI_EOF",
			"empty",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
