package on2012_3_13.cj2012qr_speakingintongues;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("java.util.Scanner",
			"on2012_3_13.cj2012qr_speakingintongues.CJ2012QR_SpeakingInTongues",
			"MULTI_NUMBER",
			"3/__ejp mysljylc kd kxveddknmc re jsicpdrysi/__rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd/__de kr kd eoya kw aej tysr re ujdr lkgc jv;;Case #1/: our language is impossible to understand/__Case #2/: there are twenty six factorial possibilities/__Case #3/: so it is okay if you want to just give up;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
