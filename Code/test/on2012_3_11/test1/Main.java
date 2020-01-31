package on2012_3_11.test1;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("java.util.Scanner",
			"on2012_3_11.test1.Test1",
			"MULTI_NUMBER",
			"2/__1/__2;;1 1/__2 2;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
