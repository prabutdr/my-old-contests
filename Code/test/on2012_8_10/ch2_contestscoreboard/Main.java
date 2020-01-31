package on2012_8_10.ch2_contestscoreboard;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.ch2_contestscoreboard.Ch2_ContestScoreboard",
			"MULTI_NUMBER",
			"2/__/__1 2 10 I/__3 1 11 C/__1 2 19 R/__1 2 21 C/__1 1 25 C/__/__1 2 10 I/__3 1 11 C/__1 2 19 R/__1 2 21 C/__1 1 25 C/__4 1 25 I/__5 1 10 C;;1 2 66/__3 1 11/__/__1 2 66/__5 1 10/__3 1 11/__4 0 0;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
