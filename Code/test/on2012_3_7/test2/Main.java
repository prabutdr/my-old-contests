package on2012_3_7.test2;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_3_7.test2.Test2",
			"SINGLE",
			"teST;;test;;true::NEw;;new;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
