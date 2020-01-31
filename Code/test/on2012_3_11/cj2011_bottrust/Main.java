package on2012_3_11.cj2011_bottrust;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("java.util.Scanner",
			"on2012_3_11.cj2011_bottrust.CJ2011_BotTrust",
			"MULTI_NUMBER",
			"empty",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
