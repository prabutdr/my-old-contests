package on2012_8_10.ch2_commonpermutation;



import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.Arrays;

public class Ch2_CommonPermutation {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        char[] word1 = in.readLine().toCharArray();
        char[] word2 = in.readLine().toCharArray();

        Arrays.sort(word1);
        Arrays.sort(word2);
        StringBuilder sb = new StringBuilder();

        int i=0, j=0;
        while(i < word1.length && j < word2.length) {
            if(word1[i] == word2[j]) {
                sb.append(word1[i]);
                i++;
                j++;
            }
            else if(word1[i] > word2[j])
                j++;
            else
                i++;
        }
        out.println(sb.toString());
	}
}
