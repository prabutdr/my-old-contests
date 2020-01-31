package com.wintech.poj;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.Arrays;

// Accepted
public class Ch2_WheresWaldorf {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        if(testNumber > 1)
            out.println();

        in.readLine();
        int m = in.readInt();
        int n = in.readInt();
        int i, j, k, direction, u, v, w = 0;

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
                                for(u=i, v=j+1, w=1; v < n && w < word.length; v++, w++) {
                                    if(grid[u][v] != word[w])
                                        break;
                                }
                                break;
                            case 1:
                                for(u=i+1, v=j+1, w=1; u < m && v < n && w < word.length; u++, v++, w++) {
                                    if(grid[u][v] != word[w])
                                        break;
                                }
                                break;
                            case 2:
                                for(u=i+1, v=j, w=1; u < m && w < word.length; u++, w++) {
                                    if(grid[u][v] != word[w])
                                        break;
                                }
                                break;
                            case 3:
                                for(u=i+1, v=j-1, w=1; u < m && v >= 0 && w < word.length; u++, v--, w++) {
                                    if(grid[u][v] != word[w])
                                        break;
                                }
                                break;
                            case 4:
                                for(u=i, v=j-1, w=1; v >= 0 && w < word.length; v--, w++) {
                                    if(grid[u][v] != word[w])
                                        break;
                                }
                                break;
                            case 5:
                                for(u=i-1, v=j-1, w=1; u >= 0 && v >= 0 && w < word.length; u--, v--, w++) {
                                    if(grid[u][v] != word[w])
                                        break;
                                }
                                break;
                            case 6:
                                for(u=i-1, v=j, w=1; u >= 0 && w < word.length; u--, w++) {
                                    if(grid[u][v] != word[w])
                                        break;
                                }
                                break;
                            case 7:
                                for(u=i-1, v=j+1, w=1; u >= 0 && v < n && w < word.length; u--, v++, w++) {
                                    if(grid[u][v] != word[w])
                                        break;
                                }
                                break;
                        }

                        if(w == word.length) {
                            out.println((i+1) + " " + (j+1));
                            break readNextWord;
                        }
                    }
                }
            }
        }
	}
}
