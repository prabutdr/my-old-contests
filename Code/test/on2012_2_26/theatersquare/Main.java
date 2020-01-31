package on2012_2_26.theatersquare;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.In",
			"on2012_2_26.theatersquare.TheaterSquare",
			"SINGLE",
			"6 6 4;;4;;true::4 4 4;;1;;true::8 8 4;;4;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
