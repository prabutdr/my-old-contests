package com.wintech.game;

/**
 * Author: Prabu
 * Date: 5/9/12 8:34 PM
 */
public class Card implements Comparable<Card> {
    private static final String values = "23456789TJQKA"; // 2-9, Ten, Jack, Queen, King, Ace (low to high)
    private static final String suits = "cdhs"; // clubs, diamonds, hearts and spades
    private static final String[] VALUE_STRING_REPRESENTATION = {"2", "3", "4", "5", "6", "7", "8", "9",
        "10", "Jack", "Queen", "King", "Ace"};
    private static final String[] SUIT_STRING_REPRESENTATION = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public static final int NUMBER_OF_CARDS = 52;
    public static final int NUMBER_OF_SUITS = 4;
    public static final int NUMBER_OF_CARDS_IN_SUITS = (NUMBER_OF_CARDS / NUMBER_OF_SUITS);

    private char value; // to hold card's value
    private char suit;  // to hold card's suit

    /**
     * Create card using given value & suit of card
     * @param value - valid character representations are "23456789TJQKA"
     * @param suit - valid character representations are "CDHS"
     */
    public Card(char value, char suit) {
        if(values.indexOf(value) == -1 || suits.indexOf(suit) == -1) {
            throw new IllegalArgumentException("Not a valid card, value - " + value + ", suit - " + suit);
        }
        this.value = value;
        this.suit = suit;
    }

    /**
     * Create card using given string representation of card
     * @param card - Two character string, first character is card's value, second character is card's suit
     */
    public Card(String card) {
        this(card.charAt(0), card.charAt(1));
    }

    /**
     * Create card using given card's rank (0 to 51)
     * @param rank - should be 0 to 51, otherwise might get unexpected result
     */
    public Card(int rank) {
        this(Card.getValue(rank), Card.getSuit(rank));
    }

    /**
     * Return card's value
     * @return
     */
    public char getValue() {
        return value;
    }

    /**
     * Return card's suit
     * @return
     */
    public char getSuit() {
        return suit;
    }

    /**
     * Return integer representation of card's value (0-12, for 13 cards)
     * @return
     */
    public int getIntValue() {
        return values.indexOf(value);
    }

    /**
     * Compare cards using only those values ("23456789TJQKA" - low to high)
     * @param o
     * @return
     */
    public int compareTo(Card o) {
        // only compare value (we can ignore suits)
        return this.getIntValue() - o.getIntValue();
    }

    @Override
    public String toString() {
        return value + "" + suit;
    }

    /**
     * Return string representation like <value> of <suit>
     * @return
     */
    public String toBreifString() {
        return VALUE_STRING_REPRESENTATION[values.indexOf(value)] + " of "
                + SUIT_STRING_REPRESENTATION[suits.indexOf(suit)];
    }

    /**
     * Return card's rank (0-51, for 52 cards)
     * @return
     */
    int getRank() {
        return getCardRank(this.value, this.suit);
    }

    /**
     * Return card's rank (0-51, for 52 cards) based on given card's value & suit
     * @param value
     * @param suit
     * @return
     */
    public static int getCardRank(char value, char suit) {
        for(int i = 0; i < NUMBER_OF_CARDS_IN_SUITS; i++) {
            if(value == values.charAt(i)) {
                for(int j = 0; j < NUMBER_OF_SUITS; j++) {
                    if(suit == suits.charAt(j))
                        return (i * NUMBER_OF_SUITS + j);
                }
            }
        }

        return -1; // for invalid cards
    }

    /**
     * To identify suit representation by card's rank
     * @param cardrank - should be 0 to 51
     * @return
     */
    public static char getSuit(int cardrank) {
        return suits.charAt(cardrank % NUMBER_OF_SUITS);
    }

    /**
     * To identify suit representation by card's rank
     * @param cardrank - should be 0 to 51
     * @return
     */
    public static char getValue(int cardrank) {
        return values.charAt(cardrank / NUMBER_OF_SUITS);
    }
}
