package on2012_8_10.ce_repeatedsubstring;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.ce_repeatedsubstring.CE_RepeatedSubstring",
			"MULTI_EOF",
			"banana/__bananabanana/__bananabananaaaaaaaaaaaaa/__bananabananaaaaaaaaaaaaaaaaaaaaaaaaaa/__abcdef/__aba/__bba/__bbaa/__aabb/__bananabananaaaaaaaaaaaaaaaaaaaaaaaaaaa/__bananabananaaaaaaaaaaaaaaaaaaaaaaaaaaaa/__aa/__ a b c/__ a b a;;an 2/__banana 6/__banana 6/__aaaaaaaaaaaaa 13/__NONE/__a 1/__b 1/__b 1/__a 1/__aaaaaaaaaaaaa 13/__aaaaaaaaaaaaaa 14/__a 1/__NONE/__ a 2/__;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
