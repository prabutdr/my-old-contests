package on2012_8_10.may2012l_chefluck;



import com.wintech.io.BaseIn;
import java.io.PrintWriter;

public class May2012L_CHEFLUCK {
    private int N, numberOfFours, numberOfSeven, reqSeven;

	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        N = in.readInt();

        numberOfFours = N / 7;
        numberOfSeven = N % 7;
        reqSeven = numberOfSeven % 4;

        if(reqSeven == 0) {
            out.println(numberOfFours * 7);
        }
        else if(numberOfFours >= reqSeven) {
            out.println((numberOfFours - reqSeven) * 7);
        }
        else {
            out.println("-1");
        }
	}
}
