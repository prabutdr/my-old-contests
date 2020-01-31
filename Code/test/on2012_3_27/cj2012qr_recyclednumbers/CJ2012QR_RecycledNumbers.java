package on2012_3_27.cj2012qr_recyclednumbers;



import java.util.Scanner;
import java.io.PrintWriter;

public class CJ2012QR_RecycledNumbers {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int A = in.nextInt();
        int B = in.nextInt();

        if(B < 10) {
            out.printf("Case #%d: 0\n", testNumber);
            return;
        }

        boolean[] visited = new boolean[B-A+1];
        int nDigits = String.valueOf(A).length()-1;
        int cycleCount, pairCount, tempi;
        StringBuilder sb;
        pairCount = 0;
        for(int i = A; i <= B; i++) {
            if(visited[i - A])
                continue;

            sb = new StringBuilder(String.valueOf(i));
            sb.insert(0, sb.charAt(sb.length() - 1));
            sb.deleteCharAt(sb.length() - 1);
            tempi = Integer.parseInt(sb.toString());
            cycleCount = 0;
            while(i != tempi) {
                if(tempi >= A && tempi <= B && visited[tempi - A] == false) {
                    cycleCount++;
                    visited[tempi - A] = true;
                }

                sb.insert(0, sb.charAt(sb.length() - 1));
                sb.deleteCharAt(sb.length() - 1);
                tempi = Integer.parseInt(sb.toString());
            }

            pairCount += (cycleCount * (cycleCount + 1)) / 2;
        }
        out.printf("Case #%d: %d\n", testNumber, pairCount);
	}
}
