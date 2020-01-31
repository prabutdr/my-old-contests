package on2012_3_7.test1;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_3_7.test1.Test1",
			"SINGLE",
			"test;;TEST;;true::new;;NEW;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
