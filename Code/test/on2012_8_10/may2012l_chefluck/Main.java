package on2012_8_10.may2012l_chefluck;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.may2012l_chefluck.May2012L_CHEFLUCK",
			"MULTI_NUMBER",
			"5/__7/__4/__11/__1/__15;;7/__0/__7/__-1/__7;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
