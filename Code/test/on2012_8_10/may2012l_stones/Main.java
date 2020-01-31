package on2012_8_10.may2012l_stones;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.may2012l_stones.May2012L_STONES",
			"MULTI_NUMBER",
			"4/__abc/__abcdef/__aA/__abAZ/__aaa/__a/__what/__none;;3/__2/__1/__0;;true::1/__ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz/__ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz;;104;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
