package on2012_3_7.apr2012l_playfit;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_3_7.apr2012l_playfit.Apr2012L_PLAYFIT",
			"MULTI_NUMBER",
			"3/__6/__3 7 1 4 2 4/__5/__5 4 3 2 1/__5/__4 3 2 2 3;;4/__UNFIT/__1;;true::3/__4/__3 1 7 6/__4/__3 7 1 6/__4/__3 7 6 1;;6/__5/__4;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
