package on2012_8_10.ch2_cryptkicker;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.ch2_cryptkicker.Ch2_CryptKicker",
			"SINGLE",
			"6/__and/__dick/__jane/__puff/__spot/__yertle/__bjvg xsb hxsn xsb qymm xsb rqat xsb pnetfn/__xxxx yyy zzzz www yyyy aaa bbbb ccc dddddd;;dick and jane and puff and spot and yertle/__**** *** **** *** **** *** **** *** ******/__;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
