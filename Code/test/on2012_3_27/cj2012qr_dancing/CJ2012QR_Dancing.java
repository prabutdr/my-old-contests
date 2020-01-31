package on2012_3_27.cj2012qr_dancing;



import java.util.Scanner;
import java.io.PrintWriter;

public class CJ2012QR_Dancing {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int N = in.nextInt();
        int S = in.nextInt();
        int p = in.nextInt();
        int ti, base, remainder;
        int result = 0;

        for(int i = 0; i < N; i++) {
            ti = in.nextInt();
            base = ti / 3;
            if(base >= p) {
                result++;
                continue;
            }

            remainder = ti % 3;
            if(remainder > 0 && (base+1) >= p) {
                result++;
                continue;
            }

            remainder = (remainder == 0 && ti != 0)? 1: remainder;
            if(S > 0 && (base+remainder) >= p) {
                S--;
                result++;
                continue;
            }
        }
        out.printf("Case #%d: %d\n", testNumber, result);
	}
}

