package com.wintech.poj;

import com.wintech.game.Card;
import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.Arrays;

public class Ch2_StackEmUp {
    private static final String values = "23456789TJQKA"; // 2-9, Ten, Jack, Queen, King, Ace (low to high)
    private static final String suits = "cdhs"; // clubs, diamonds, hearts and spades

    public void solve(int testNumber, BaseIn in, PrintWriter out) {
        int shuffleCount = in.readInt();
        int[][] shuffles = new int[shuffleCount][Card.NUMBER_OF_CARDS];
        Card[] deck = new Card[Card.NUMBER_OF_CARDS];
        Card[] tempDeck = new Card[Card.NUMBER_OF_CARDS];
        int applyShuffle, si;
        Card temp;
        boolean[] swapped;

        for(int i = 0; i < shuffleCount; i++) {
            for(int j = 0; j < Card.NUMBER_OF_CARDS; j++) {
                shuffles[i][j] = in.readInt();
            }
        }
        //System.out.println("shuffles: " + Arrays.deepToString(shuffles));

        si = 0;
        for(int i = 0; i < suits.length(); i++) {
            for(int j = 0; j < values.length(); j++) {
                deck[si++] = new Card(values.charAt(j), suits.charAt(i));
            }
        }

        //in.readLine();
        while(!in.isEOF()) {
            try {
                applyShuffle = Integer.parseInt(in.readLine()) - 1;
                //System.out.println("applyShuffle: " + applyShuffle);
            }
            catch (Exception e) {
                break;
            }
            catch(UnknownError e) {
                break;
            }

            swapped = new boolean[Card.NUMBER_OF_CARDS];
            for(int i = 0; i < Card.NUMBER_OF_CARDS; i++) {
                si = shuffles[applyShuffle][i] - 1;
                /*if(swapped[i] == false && i != si) {
                    temp = deck[i];
                    deck[i] = deck[si];
                    deck[si] = temp;
                    swapped[i] = true;
                    swapped[si]  = true;
                }*/
                tempDeck[i] = deck[si];
            }
            for(int i = 0; i < Card.NUMBER_OF_CARDS; i++) {
                deck[i] = tempDeck[i];
            }
        }

        if(testNumber > 1) {
            out.println();
        }
        for(int i = 0; i < Card.NUMBER_OF_CARDS; i++) {
            out.println(deck[i].toBreifString());
        }
    }
}
