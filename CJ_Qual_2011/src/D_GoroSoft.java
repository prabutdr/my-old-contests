/*
 * To change this D_GoroSoft, choose Tools | D_GoroSofts
 * and open the D_GoroSoft in the editor.
 */

/**
 * @date 07-May-2011
 * @author Prabu
 */

import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class D_GoroSoft {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            D_GoroSoft solver = new D_GoroSoft();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "D_GoroSoft";
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
        int size, i, currentItem, currentPos, targetPos, moveCount;
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
            Collections.sort(sortedList);

            moveCount = 0;
            for(i = 0; i < size; i++) {
                if(visitedFlag[i])
                    continue;

                currentPos = i;
                //visitedFlag[i] = true;
                //currentItem = initList[i];
                while(true) {

                    currentItem = initList[currentPos];
                    if(sortedList.indexOf(initList[currentPos]) == currentPos) {
                        visitedFlag[i] = true;
                        //initList[i] = currentItem;
                        i = 0;
                        break;
                    }

                    targetPos = sortedList.indexOf(currentItem);
                        //visitedFlag[i] = true;

                    while(visitedFlag[targetPos]) //duplicate & already placed
                        targetPos++;

                    visitedFlag[targetPos] = true;
                    currentItem = initList[targetPos];
                    initList[currentPos] = initList[targetPos];
                    initList[targetPos] = sortedList.get(targetPos);
                    moveCount++;
                    currentPos = targetPos;
                    System.out.println("initList: " + Arrays.toString(initList));
                    //System.out.println("visitedFlag: " + Arrays.toString(visitedFlag));
                }
                    System.out.println("outinitList: " + Arrays.toString(initList));
                    //System.out.println("outvisitedFlag: " + Arrays.toString(visitedFlag));
            }

            System.out.printf("Case #%d: %.6f\n", tci, (moveCount * 2.0));
        }
    }
/******************************************************************************/
}
