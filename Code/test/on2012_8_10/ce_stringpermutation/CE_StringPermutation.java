package on2012_8_10.ce_stringpermutation;



import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeSet;

public class CE_StringPermutation {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        String input = in.readLine();
        char[] text = input.toCharArray();
        //System.out.println(input);
        Arrays.sort(text);
        int i, j, largeIdx;
        int temp;
        int[] chOrder = new int[text.length];
        for(i = 0; i < text.length; i++) {
            chOrder[i] = i;
        }
        print(out, text, chOrder);
        for(i = chOrder.length - 2; i >= 0; i--) {
            //if(text[i] < text[i+1]) {
                largeIdx = findNextLargeElementStartIdx(chOrder[i], chOrder, i+1, chOrder.length-1);
                if(largeIdx != -1) {
                    temp = chOrder[i];
                    chOrder[i] = chOrder[largeIdx];
                    chOrder[largeIdx] = temp;
                    /*for(j = largeIdx+1; j < text.length; j++) {

                    }*/
                    i = chOrder.length - 1;
                    out.write(", "); print(out, text, chOrder);//out.write(text);
                    //System.out.println(String.valueOf(text));
                    //System.out.println("1: i=" + i);
                }
            //}
            else if(chOrder[i] > chOrder[i+1]) {
                // if previous element is not big, swap elements, so that portion of array will be sorted.
                //temp = text[i];
                //text[i] = text[i+1];
                //text[i+1] = temp;
                for(j = i; j < chOrder.length-1 && chOrder[j] > chOrder[j+1]; j++) {
                    temp = chOrder[j];
                    chOrder[j] = chOrder[j+1];
                    chOrder[j+1] = temp;
                }
                //System.out.println("2: i=" + i);
            }
        }

        /*int[] array = {1, 3, 4, 4, 4, 4, 4, 6, 8};
        Arrays.sort(array);
        for(int i = -1; i < 12; i++) {
            out.printf("smallerElementsCount(%d, array) : %d\n", i,
                    findNextLargeElementStartIdx(i, array, 0, array.length - 1));
        } */

        out.close();
    }

    private void print(PrintWriter out, char[] text, int[] chOrder) {
        for(int i = 0; i < chOrder.length; i++) {
            out.write(text[chOrder[i]]);
        }
    }

    /**
     * Find count of elements larger than given key using binary search
     */
    private int findNextLargeElementStartIdx(int key, int[] array, int li, int hi) {
        int maxIdx = hi;
        int rank = 0;
        while(li <= hi) {
            rank = li + (hi - li) / 2;
            if(array[rank] < key)
                li = rank + 1;
            else if(array[rank] > key)
                hi = rank - 1;
            else
                break;
        }

        if(li <= hi) { // key found at rank pos, then eliminate equivalent to key
            do {
                rank++;
            }
            while(rank < array.length && array[rank] == key);
        }
        else {  // key not found
            rank = li;
        }

        if(rank > maxIdx)
            return -1;
        else
            return li;
    }
}

// abcde, abced, abdce, abdec, abecd, abedc, acbde, acbed, acdbe, acdeb, acebd, acedb,
// adbce, adbec, adcbe, adceb, adebc, adecb, aebcd, aebdc, aecbd, aecdb, aedbc, aedcb,
// bacde, baced, badce, badec, baecd, baedc, bcade, bcaed, bcdae, bcdea, bcead, bceda,
// bdace, bdaec, bdcae, bdcea, bdeac, bdeca, beacd, beadc, becad, becda, bedac, bedca,
// cabde, cabed, cadbe, cadeb, caebd, caedb, cbade, cbaed, cbdae, cbdea, cbead, cbeda,
// cdabe, cdaeb, cdbae, cdbea, cdeab, cdeba, ceabd, ceadb, cebad, cebda, cedab, cedba,
// dabce, dabec, dacbe, daceb, daebc, daecb, dbace, dbaec, dbcae, dbcea, dbeac, dbeca,
// dcabe, dcaeb, dcbae, dcbea, dceab, dceba, deabc, deacb, debac, debca, decab, decba,
// eabcd, eabdc, eacbd, eacdb, eadbc, eadcb, ebacd, ebadc, ebcad, ebcda, ebdac, ebdca,
// ecabd, ecadb, ecbad, ecbda, ecdab, ecdba, edabc, edacb, edbac, edbca, edcab, edcba

// abcde, abced, abdce, abdec, abecd, abedc, acbde, acbed, acdbe, acdeb, acebd, acedb,
// adbce, adbec, adcbe, adceb, adebc, adecb, aebcd, aebdc, aecbd, aecdb, aedbc, aedcb,
// bacde, baced, badce, badec, baecd, baedc, bcade, bcaed, bcdae, bcdea, bcead, bceda,
// bdace, bdaec, bdcae, bdcea, bdeac, bdeca, beacd, beadc, becad, becda, bedac, bedca,
// cabde, cabed, cadbe, cadeb, caebd, caedb, cbade, cbaed, cbdae, cbdea, cbead, cbeda,
// cdabe, cdaeb, cdbae, cdbea, cdeab, cdeba, ceabd, ceadb, cebad, cebda, cedab, cedba,
// dabce, dabec, dacbe, daceb, daebc, daecb, dbace, dbaec, dbcae, dbcea, dbeac, dbeca,
// dcabe, dcaeb, dcbae, dcbea, dceab, dceba, deabc, deacb, debac, debca, decab, decba,
// eabcd, eabdc, eacbd, eacdb, eadbc, eadcb, ebacd, ebadc, ebcad, ebcda, ebdac, ebdca,
// ecabd, ecadb, ecbad, ecbda, ecdab, ecdba, edabc, edacb, edbac, edbca, edcab, edcba

// abcde, abced, abdce, abdec, abecd, abedc, acbde, acbed, acdbe, acdeb, acebd, acedb,
// adbce, adbec, adcbe, adceb, adebc, adecb, aebcd, aebdc, aecbd, aecdb, aedbc, aedcb,
// bacde, baced, badce, badec, baecd, baedc, bcade, bcaed, bcdae, bcdea, bcead, bceda,
// bdace, bdaec, bdcae, bdcea, bdeac, bdeca, beacd, beadc, becad, becda, bedac, bedca,
// cabde, cabed, cadbe, cadeb, caebd, caedb, cbade, cbaed, cbdae, cbdea, cbead, cbeda,
// cdabe, cdaeb, cdbae, cdbea, cdeab, cdeba, ceabd, ceadb, cebad, cebda, cedab, cedba,
// dabce, dabec, dacbe, daceb, daebc, daecb, dbace, dbaec, dbcae, dbcea, dbeac, dbeca,
// dcabe, dcaeb, dcbae, dcbea, dceab, dceba, deabc, deacb, debac, debca, decab, decba,
// eabcd, eabdc, eacbd, eacdb, eadbc, eadcb, ebacd, ebadc, ebcad, ebcda, ebdac, ebdca,
// ecabd, ecadb, ecbad, ecbda, ecdab, ecdba, edabc, edacb, edbac, edbca, edcab, edcba

// aabde, aabed, aadbe, aadeb, aaebd, aaedb, abade, abaed, abdae, abdea, abead, abeda,
// adabe, adaeb, adbae, adbea, adeab, adeba, aeabd, aeadb, aebad, aebda, aedab, aedba,
// aabde, aabed, aadbe, aadeb, aaebd, aaedb, abade, abaed, abdae, abdea, abead, abeda,
// adabe, adaeb, adbae, adbea, adeab, adeba, aeabd, aeadb, aebad, aebda, aedab, aedba,
// baade, baaed, badae, badea, baead, baeda, baade, baaed, badae, badea, baead, baeda,
// bdaae, bdaea, bdaae, bdaea, bdeaa, bdeaa, beaad, beada, beaad, beada, bedaa, bedaa,
// daabe, daaeb, dabae, dabea, daeab, daeba, daabe, daaeb, dabae, dabea, daeab, daeba,
// dbaae, dbaea, dbaae, dbaea, dbeaa, dbeaa, deaab, deaba, deaab, deaba, debaa, debaa,
// eaabd, eaadb, eabad, eabda, eadab, eadba, eaabd, eaadb, eabad, eabda, eadab, eadba,
// ebaad, ebada, ebaad, ebada, ebdaa, ebdaa, edaab, edaba, edaab, edaba, edbaa, edbaa


// abcd, abdc, acbd, acdb, adbc, adcb,
// bacd, badc, bcad, bcda, bdac, bdca,
// cabd, cadb, cbad, cbda, cdab, cdba,
// dabc, dacb, dbac, dbca, dcab, dcba

// abcd, abdc, acbd, acdb, adbc, adcb,
// bacd, badc, bcad, bcda, bdac, bdca,
// cabd, cadb, cbad, cbda, cdab, cdba,
// dabc, dacb, dbac, dbca, dcab, dcba

// abcd, abdc, acbd, acdb, adbc, adcb,
// bacd, badc, bcad, bcda, bdac, bdca,
// cabd, cadb, cbad, cbda, cdab, cdba,
// dabc, dacb, dbac, dbca, dcab, dcba

// abcde, abced, abdce, abdec, abecd, abedc, acbde, acbed, acdbe, acdeb, acebd, acedb,
// adbce, adbec, adcbe, adceb, adebc, adecb, aebcd, aebdc, aecbd, aecdb, aedbc, aedcb,
// bacde, baced, badce, badec, baecd, baedc, bcade, bcaed, bcdae, bcdea, bcead, bceda,
// bdace, bdaec, bdcae, bdcea, bdeac, bdeca, beacd, beadc, becad, becda, bedac, bedca,
// cabde, cabed, cadbe, cadeb, caebd, caedb, cbade, cbaed, cbdae, cbdea, cbead, cbeda,
// cdabe, cdaeb, cdbae, cdbea, cdeab, cdeba, ceabd, ceadb, cebad, cebda, cedab, cedba,
// dabce, dabec, dacbe, daceb, daebc, daecb, dbace, dbaec, dbcae, dbcea, dbeac, dbeca,
// dcabe, dcaeb, dcbae, dcbea, dceab, dceba, deabc, deacb, debac, debca, decab, decba,
// eabcd, eabdc, eacbd, eacdb, eadbc, eadcb, ebacd, ebadc, ebcad, ebcda, ebdac, ebdca,
// ecabd, ecadb, ecbad, ecbda, ecdab, ecdba, edabc, edacb, edbac, edbca, edcab, edcba, Case #1: edcba
