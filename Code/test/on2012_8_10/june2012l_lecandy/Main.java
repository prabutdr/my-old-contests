package on2012_8_10.june2012l_lecandy;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.june2012l_lecandy.June2012L_LECANDY",
			"MULTI_NUMBER",
			"2/__2 3/__1 1/__3 7/__4 2 2;;Yes/__No/__;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
