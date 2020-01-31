package on2014_3_12.c2a_winner;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2014_3_12.c2a_winner.C2A_Winner",
			"SINGLE",
			"3/__mike 3/__andrew 5/__mike 2;;andrew;;true::3/__andrew 3/__andrew 2/__mike 5;;andrew;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
