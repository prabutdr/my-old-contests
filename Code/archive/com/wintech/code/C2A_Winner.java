package com.wintech.code;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;
import java.util.Set;

public class C2A_Winner {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        int rounds = in.readInt();
        String[] name = new String[rounds];
        int[] score = new int[rounds];
        Map<String, Integer> scoreboard = new HashMap<String, Integer>();

        // Read inputs and calculate score sum for all
        for(int i = 0; i < rounds; i++) {
            name[i] = in.readString();
            score[i] = in.readInt();
            if(scoreboard.containsKey(name[i])) {
                scoreboard.put(name[i], scoreboard.get(name[i]) + score[i]);
            }
            else {
                scoreboard.put(name[i], score[i]);
            }
        }

        // find maximum score
        int maxScore = 0;
        for(Integer value: scoreboard.values()) {
            maxScore = Math.max(maxScore, value);
        }

        // find possible winners
        Set<String> winners = new HashSet<String>();
        for(Map.Entry<String, Integer> entry: scoreboard.entrySet()) {
            if(entry.getValue() >= maxScore) {
                winners.add(entry.getKey());
            }
        }

        scoreboard.clear();
        for(int i = 0; i < rounds; i++) {
            if(winners.contains(name[i])) {
                if(scoreboard.containsKey(name[i])) {
                    scoreboard.put(name[i], scoreboard.get(name[i]) + score[i]);
                }
                else {
                    scoreboard.put(name[i], score[i]);
                }

                if(scoreboard.get(name[i]) >= maxScore) {
                    out.print(name[i]);
                    break;
                }
            }
        }

/*
        int rounds = in.readInt();
        String name;
        int score;
        HashMap<String, Contestant> scoreBoard = new HashMap<String, Contestant>();

        for(int i = 0; i < rounds; i++) {
            name = in.readString();
            score = in.readInt();
            Contestant contestant = scoreBoard.get(name);
            if(contestant == null) {
                contestant = new Contestant(name, score, i);
                scoreBoard.put(name, contestant);
            }
            else {
                contestant.addScore(score, i);
            }
        }

        Contestant winner = null;
        for(Contestant contestant: scoreBoard.values()) {
            if(winner == null) {
                winner = contestant;
            }
            else if(winner.compareTo(contestant) < 0) {
                winner = contestant;
            }
        }
        out.print(winner.getName());
*/
	}
}

/*
class Contestant implements Comparable<Contestant> {
    private String name;
    private int score;
    private int maxReachedRound;
    private int maxScoreReached;

    Contestant(String name, int score, int maxReachedRound) {
        this.name = name;
        this.score += score;
        if(this.score > this.maxScoreReached) {
            this.maxReachedRound = maxReachedRound;
            this.maxScoreReached = this.score;
        }

//        this.score = score;
//        this.maxReachedRound = maxReachedRound;
//        this.maxScoreReached = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMaxReachedRound() {
        return maxReachedRound;
    }

    public void setMaxReachedRound(int maxReachedRound) {
        this.maxReachedRound = maxReachedRound;
    }

    public void addScore(int score, int round) {
        this.score += score;
        if(this.score > this.maxScoreReached) {
            maxReachedRound = round;
            maxScoreReached = this.score;
        }
    }

    @Override
    public int compareTo(Contestant o) {
        if(this.score > o.score)
            return 1;
        if(this.score < o.score)
            return -1;
        if(this.maxReachedRound < o.maxReachedRound)
            return 1;
        if(this.maxReachedRound > o.maxReachedRound)
            return -1;
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
*/
