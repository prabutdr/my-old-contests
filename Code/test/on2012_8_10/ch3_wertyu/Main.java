package on2012_8_10.ch3_wertyu;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.ch3_wertyu.Ch3_WERTYU",
			"SINGLE",
			"O S, GOMR YPFSU;;I AM FINE TODAY;;true::O S, GOMR YPFSU/__O S, GOMR YPFS;;I AM FINE TODAY/__I AM FINE TODA;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
