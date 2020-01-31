package on2012_3_29.test;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_3_29.test.Test",
			"SINGLE",
			"empty",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
