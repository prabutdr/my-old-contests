/*
 * To change this D_GoroSoft_1, choose Tools | D_GoroSoft_1s
 * and open the D_GoroSoft_1 in the editor.
 */

/**
 * @date 07-May-2011
 * @author Prabu
 */

import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class D_GoroSoft_1 {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            D_GoroSoft_1 solver = new D_GoroSoft_1();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "D-small-attempt0";
    private static Scanner sc;
    private static PrintWriter out;

    void openIO() throws IOException {
        String inFileName = "IO/Input/" + FILENAME + ".IN";
        String outFileName = "IO/Output/" + FILENAME + ".OUT";

        sc = new Scanner(new File(inFileName));
        out = new PrintWriter(new File(outFileName));
    }

    void closeIO() throws IOException {
        out.close();
        sc.close();
    }

/******************************************************************************/
    void solve() throws IOException {
        int tc = sc.nextInt();
        int size, i, targetPos, moveCount;
        int[] initList;
        ArrayList<Integer> sortedList;
        boolean[] visitedFlag;
        for(int tci = 1; tci <= tc; tci++) {
            size = sc.nextInt();
            initList = new int[size];
            sortedList = new ArrayList<Integer>(size);
            visitedFlag = new boolean[size];

            for(i = 0; i < size; i++) {
                initList[i] = sc.nextInt();
                sortedList.add(initList[i]);
            }
            System.out.println("initList: " + Arrays.toString(initList));
            Collections.sort(sortedList);

            moveCount = 0;
            for(i = 0; i < size; i++) {
                if(visitedFlag[i])
                    continue;

                while(true) {
                    if(sortedList.indexOf(initList[i]) == i) {
                        visitedFlag[i] = true;
                        sortedList.set(i, Integer.MIN_VALUE);
                        break;
                    }

                    targetPos = sortedList.indexOf(initList[i]);

                    while(visitedFlag[targetPos]) //duplicate & already placed
                        targetPos++;

                    visitedFlag[targetPos] = true;
                    initList[i] = initList[targetPos];
                    initList[targetPos] = sortedList.get(targetPos);
                    sortedList.set(targetPos, Integer.MIN_VALUE);
                    moveCount++;
                    //System.out.println("initList: " + Arrays.toString(initList));
                    //System.out.println("sortedList: " + sortedList);
                }
                System.out.println("movecount: " + moveCount);
                //moveCount = 0;
                    //System.out.println("outinitList: " + Arrays.toString(initList));
            }

            out.printf("Case #%d: %.6f\n", tci, (moveCount * 2.0));
        }
    }
/******************************************************************************/
}
