package on2012_3_27.cj2012qr_dancing;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("java.util.Scanner",
			"on2012_3_27.cj2012qr_dancing.CJ2012QR_Dancing",
			"MULTI_NUMBER",
			"4/__3 1 5 15 13 11/__3 0 8 23 22 21/__2 1 1 8 0/__6 2 8 29 20 8 18 18 21/__;;Case #1/: 3/__Case #2/: 2/__Case #3/: 1/__Case #4/: 3/__ ;;true::5/__4 0 5 9 10 11 12/__4 1 5 9 10 11 12/__4 2 5 9 10 11 12/__4 3 5 9 10 11 12/__4 4 5 9 10 11 12;;Case #1/: 0/__Case #2/: 1/__Case #3/: 2/__Case #4/: 2/__Case #5/: 2;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
