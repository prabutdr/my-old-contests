package on2012_8_10.pe24_nth_str_perm;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.pe24_nth_str_perm.PE24_Nth_Str_Perm",
			"MULTI_NUMBER",
			"1/__abcde/__100;;Case #1/: eacdb;;true::3/__0123456789/__1/__0123456789/__2/__0123456789/__1000000;;Case #1/: 0123456789/__Case #2/: 0123456798/__;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
