package com.wintech.poj;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.Arrays;

// Accepted
public class Ch2_WheresWaldorf_1 {
    public void solve(int testNumber, BaseIn in, PrintWriter out) {
        if(testNumber > 1)
            out.println();

        in.readLine();
        int m = in.readInt();
        int n = in.readInt();
        int i, j=0, k, direction, u, v, w = 0;

        char[][] grid = new char[m][];
        for(i = 0; i < m; i++) {
            grid[i] = in.readLine().toLowerCase().toCharArray();
        }
        //System.out.println(m + " " + n);
        //System.out.println(Arrays.deepToString(grid));
        char[] word;

        for(k = in.readInt(); k > 0; k--) {
            word = in.readLine().toLowerCase().toCharArray();
            //System.out.printf("Word %d - %s\n", k, String.valueOf(word));
            readNextWord:
            for(i = 0; i < m; i++) {
                for(j = 0; j < n; j++) {
                    //System.out.println(grid[i][j] + " " + word[0]);
                    if(grid[i][j] != word[0])
                        continue;
                    //System.out.println("pass");
                    for(direction = 0; direction < 8; direction++) {
                        switch (direction) {
                            case 0:
                                if(isWordExistInDirection(grid, word, i, j, 0, 1)) {
                                    break readNextWord;
                                }
                                break;
                            case 1:
                                if(isWordExistInDirection(grid, word, i, j, 1, 1)) {
                                    break readNextWord;
                                }
                                break;
                            case 2:
                                if(isWordExistInDirection(grid, word, i, j, 1, 0)) {
                                    break readNextWord;
                                }
                                break;
                            case 3:
                                if(isWordExistInDirection(grid, word, i, j, 1, -1)) {
                                    break readNextWord;
                                }
                                break;
                            case 4:
                                if(isWordExistInDirection(grid, word, i, j, 0, -1)) {
                                    break readNextWord;
                                }
                                break;
                            case 5:
                                if(isWordExistInDirection(grid, word, i, j, -1, -1)) {
                                    break readNextWord;
                                }
                                break;
                            case 6:
                                if(isWordExistInDirection(grid, word, i, j, -1, 0)) {
                                    break readNextWord;
                                }
                                break;
                            case 7:
                                if(isWordExistInDirection(grid, word, i, j, -1, 1)) {
                                    break readNextWord;
                                }
                                break;
                        }
                    }
                }
            }
            out.println((i+1) + " " + (j+1));
        }
    }

    private boolean isWordExistInDirection(char[][] grid, char[] word, int row, int col, int rowstep, int colstep) {
        int i, j, w;
        for(i=row+rowstep, j=col+colstep, w=1;
            i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && w < word.length;
            i+=rowstep, j+=colstep, w++) {
            if(grid[i][j] != word[w])
                return false;
        }
        if(w == word.length) {
            return true;
        }
        return false;
    }
}
