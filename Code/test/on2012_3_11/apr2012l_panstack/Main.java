package on2012_3_11.apr2012l_panstack;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_3_11.apr2012l_panstack.Apr2012L_PANSTACK",
			"MULTI_NUMBER",
			"2/__1/__2;;1/__2;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
