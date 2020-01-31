package on2012_8_10.ch2_commonpermutation;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.ch2_commonpermutation.Ch2_CommonPermutation",
			"MULTI_EOF",
			"pretty/__women/__walking/__down/__the/__street;;e/__nw/__et/__;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
