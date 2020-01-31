package on2012_3_7.apr2012l_double;



import com.wintech.io.BaseIn;
import java.io.PrintWriter;

public class Apr2012L_DOUBLE {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        int N = in.readInt();
        out.println(N - (N%2));
	}
}
