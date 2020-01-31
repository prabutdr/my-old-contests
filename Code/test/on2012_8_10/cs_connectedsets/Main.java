package on2012_8_10.cs_connectedsets;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("com.wintech.io.BaseIn",
			"on2012_8_10.cs_connectedsets.CS_ConnectedSets",
			"MULTI_NUMBER",
			"4/__4/__0 0 1 0/__1 0 1 0/__0 1 0 0/__1 1 1 1/__4/__1 0 0 1/__0 0 0 0/__0 1 1 0/__1 0 0 1/__5/__1 0 0 1 1/__0 0 1 0 0/__0 0 0 0 0/__1 1 1 1 1/__0 0 0 0 0/__8/__0 0 1 0 0 1 0 0/__1 0 0 0 0 0 0 1/__0 0 1 0 0 1 0 1/__0 1 0 0 0 1 0 0/__1 0 0 0 0 0 0 0/__0 0 1 1 0 1 1 0/__1 0 1 1 0 1 1 0/__0 0 0 0 0 0 0 0;;1/__3/__3/__9/__;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
