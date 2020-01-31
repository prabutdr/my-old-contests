package on2012_8_10.cj2012r1a_kingdomrush;



import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CJ2012R1A_KingdomRush {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Point[] points = new Point[n];
        for(int i = 0; i < n; i++) {
            points[i] = new Point(in.nextInt(), in.nextInt());
        }

        Arrays.sort(points);
        //out.println(Arrays.toString(points));

        int earnStars = 0;
        int attempt = 0;
        int prevEarnStatus = -1;
        for(int i = 0; i < n; i++) {
            prevEarnStatus = -1;
            while(prevEarnStatus != earnStars && points[i].b > earnStars) {
                prevEarnStatus = earnStars;
                for(int j = n-1; j >= i && points[i].b > earnStars; j--) {
                    if(points[j].a <= earnStars) {
                        points[j].v1 = true;
                        earnStars++;
                        attempt++;
                    }
                }
            }
            if(points[i].b <= earnStars) {
                if(points[i].v1 == false) {
                    points[i].v2 = true;
                    earnStars+=2;
                    attempt++;
                }
                else {
                    points[i].v2 = true;
                    earnStars++;
                    attempt++;
                }
            }
            else {
                out.printf("Case #%d: Too Bad\n", testNumber);
                return;
            }

        }
        out.printf("Case #%d: %d\n", testNumber, attempt);

    }

    class Point implements Comparable<Point> {
        public int a, b;
        public boolean v1, v2;

        Point(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public String toString() {
            return "(" + a + ", " + b +")";
        }

        @Override
        public int compareTo(Point o) {
            if(this.b > o.b)
                return 1;
            if(this.b < o.b)
                return -1;

            return this.a - o.a;
        }
    }
}
