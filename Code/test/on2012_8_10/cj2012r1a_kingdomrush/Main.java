package on2012_8_10.cj2012r1a_kingdomrush;

import net.egork.chelper.tester.Tester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!Tester.test("java.util.Scanner",
			"on2012_8_10.cj2012r1a_kingdomrush.CJ2012R1A_KingdomRush",
			"MULTI_NUMBER",
			"4/__ 2/__ 0 1/__ 0 2/__ 3/__ 2 2/__ 0 0/__ 4 4/__ 1/__ 1 1/__ 5/__ 0 5/__ 0 1/__ 1 1/__ 4 7/__ 5 6 ;;Case #1/: 3/__Case #2/: 3/__Case #3/: Too Bad/__Case #4/: 6/__;;true::4/__4/__4 7/__3 6/__0 2/__1 5/__1/__0 1/__1/__0 0/__10/__338 722/__1043 1161/__141 644/__417 477/__1243 1963/__124 396/__1402 1851/__1394 1414/__807 1341/__307 1175;;Case #1/: 7;;true",
			"java.io.PrintWriter"))
		{
			Assert.fail();
		}
	}
}
