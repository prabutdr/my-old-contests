package on2012_3_7.apr2012l_double;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_3_7.apr2012l_double.Apr2012L_DOUBLE",
			"MULTI_NUMBER",
			"2/__2/__4;;2/__4;;true::3/__1/__3/__5;;0/__2/__4;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
