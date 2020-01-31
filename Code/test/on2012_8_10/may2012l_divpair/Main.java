package on2012_8_10.may2012l_divpair;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.may2012l_divpair.May2012L_DIVPAIR",
			"MULTI_NUMBER",
			"3/__2 3/__4 3/__1 6;;1/__2/__0;;true::3/__10 3/__10000 3/__3 3;;15/__16665000/__1;;true::5/__1000000000 2/__1000000000 3/__1000000000 4/__1000000000 5/__1000000000 1000000000;;250000000000000000/__166666666500000000/__124999999750000000/__99999999700000000/__0;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
