package com.wintech.poj;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

// Accepted
public class Ch3_CryptKicker_II {
    final static char[] encLine = "the quick brown fox jumps over the lazy dog".toCharArray();

	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        if(testNumber == 1) in.readLine(); // to skip one line
        else out.println();

        ArrayList<char[]> lines = new ArrayList<char[]>();
        char[] line;
        char[] map = new char[26];
        boolean mapFound = false;

        while(!in.isEOF()) {
            line = in.readLine().toCharArray();
            if(line.length == 0)
                break;
            lines.add(line);

            if(mapFound == false && line.length == encLine.length && getCharMap(line, map)) {
                mapFound = true;
            }
        }

        if(mapFound == false) {
            out.println("No solution.");
            return;
        }

        for(char[] line1: lines) {
            for(char ch: line1) {
                if(ch == ' ') {
                    out.print(ch);
                    continue;
                }
                out.print(map[ch-'a']);
            }
            out.println();
        }
	}

    private boolean getCharMap(char[] line, char[] map) {
        Arrays.fill(map, '\0');
        int mapIdx, count, i, j;
        count = 0;
        for(i = 0; i < line.length; i++) {
            if(encLine[i] == ' ') {
                if(encLine[i] == line[i])
                    continue;
                else
                    return false;
            }
            mapIdx = line[i] - 'a';
            if(map[mapIdx] != '\0') {
                if(map[mapIdx] == encLine[i])
                    continue;
                else
                    return false;
            }

            for(j = 0; j < map.length; j++) {
                if(map[j] == encLine[i])
                    break;
            }
            if(j != map.length)
                return false; // already char mapped to another character

            map[mapIdx] = encLine[i];
            count++;
        }

        if(count == map.length)
            return true;
        else
            return false;
    }
}
