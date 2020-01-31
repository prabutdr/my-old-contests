package on2012_8_10.may2012l_twstr;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.may2012l_twstr.May2012L_TWSTR",
			"SINGLE",
			"4/__flour-with-eggs 100/__chicken-ham -10/__flour-without-eggs 200/__fish-with-pepper 1100/__6/__f/__flour-with/__flour-with-/__c/__fl/__chik;;fish-with-pepper/__flour-without-eggs/__flour-with-eggs/__chicken-ham/__flour-without-eggs/__NO/__;;true::5/__flour-with-eggs 100/__chicken-ham -10/__chicken-ham 10/__flour-without-eggs 200/__fish-with-pepper 1100/__6/__f/__flour-with/__flour-with-/__c/__fl/__chik;;fish-with-pepper/__flour-without-eggs/__flour-with-eggs/__chicken-ham/__flour-without-eggs/__NO/__;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
