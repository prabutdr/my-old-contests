package on2012_2_26.theatersquare;



import com.wintech.io.In;
import java.io.PrintWriter;

public class TheaterSquare {
	public void solve(int testNumber, In in, PrintWriter out) {
        long m = in.readLong();
        long n = in.readLong();
        double a = in.readLong();
        out.printf("%.0f", Math.ceil(m/a) * Math.ceil(n/a));
	}
}
