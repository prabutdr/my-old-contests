package com.wintech.poj;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Ch2_ErdosNumbers_TLE1 {
    public void solve(int testNumber, BaseIn in, PrintWriter out) {
        int p = in.readInt();
        int n = in.readInt();
        in.readLine();

        ArrayList<ArrayList<String>> coauthors = new ArrayList<ArrayList<String>>();
        HashMap<String, Integer> authorsRank = new HashMap<String, Integer>();
        String[] authors;
        String line;
        String erdos = "Erdos, P.";
        boolean erdosFound = false, updateReq = false;
        Integer rank;

        rank = 1;
        for(int i = 0; i < p; i++) {
            line = in.readLine().split(":")[0];
            erdosFound = (line.indexOf(erdos) != -1);
            authors = line.split(",");
            if(erdosFound) {
                for(int j = 0; j < authors.length; j+=2) {
                    authorsRank.put(authors[j].trim() + ", " + authors[j+1].trim(), rank);
                }
                updateReq = true;
            }
            else {
                ArrayList<String> coauthor = new ArrayList<String>();
                for(int j = 0; j < authors.length; j+=2) {
                    coauthor.add(authors[j].trim() + ", " + authors[j+1].trim());
                }
                coauthors.add(coauthor);
            }
        }
        //out.println(coauthors);
        //out.println(authorsRank);

        while(updateReq) {
            updateReq = false;
            HashMap<String, Integer> authorsRankTemp = new HashMap<String, Integer>();
            for(java.util.Map.Entry<String, Integer> entry: authorsRank.entrySet()) {
                if(entry.getValue() == rank) {
                    for(int i = 0; i < coauthors.size(); i++) {
                        ArrayList<String> list = coauthors.get(i);
                        if(list.contains(entry.getKey())) {
                            for(String author: list) {
                                if(!authorsRank.containsKey(author)) {
                                    authorsRankTemp.put(author, rank+1);
                                }
                            }
                            updateReq = true;
                            coauthors.remove(i);
                            i--;
                        }
                    }
                }
            }
            authorsRank.putAll(authorsRankTemp);
            rank++;
        }
        //out.println(coauthors);
        //out.println(authorsRank);

        out.println("Scenario " + testNumber);
        for(int i = 0; i < n; i++) {
            line = in.readLine();
            rank = authorsRank.get(line);
            if(rank == null) {
                out.println(line + " infinity");
            }
            else {
                out.println(line + " " + rank);
            }
        }
    }
}
