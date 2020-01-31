package on2012_8_10.june2012l_resq;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.june2012l_resq.June2012L_RESQ",
			"MULTI_NUMBER",
			"4/__20/__13/__8/__4;;1/__12/__2/__0/__;;true::20/__1/__2/__3/__4/__5/__6/__7/__8/__9/__10/__11/__12/__13/__14/__15/__16/__17/__18/__19/__20;;;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
