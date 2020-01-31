package on2012_8_10.jun2012l_lucky8_1;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.jun2012l_lucky8_1.Jun2012L_LUCKY8_1",
			"MULTI_NUMBER",
			"empty",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
