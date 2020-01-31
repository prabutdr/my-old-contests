package on2012_8_10.ch2_goingtowar;



import com.wintech.game.Card;
import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Ch2_GoingToWar {
    public final int MAX_STEP_COUNT = 1000000;

	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        LinkedList<Card> player1Q = new LinkedList<Card>();
        LinkedList<Card> player2Q = new LinkedList<Card>();
        LinkedList<Card> tableQ = new LinkedList<Card>();
        int moveCount = 0, compare;
        Card card1, card2;
        boolean inWar = false;

        // Read input
        for(int i = 0; i < 26; i++) {
            player1Q.add(new Card(in.readString()));
        }
        for(int i = 0; i < 26; i++) {
            player2Q.add(new Card(in.readString()));
        }

        // Game starts here
        while(moveCount <= MAX_STEP_COUNT) {
            if(player1Q.isEmpty() || player2Q.isEmpty()) {
                break;
            }
            moveCount++;
            card1 = player1Q.poll();
            card2 = player2Q.poll();
            tableQ.push(card1);
            tableQ.push(card2);
            if(inWar) {
                inWar = false;
            }
            else {
                compare = card1.compareTo(card2);
                if(compare == 0) {
                    // both equal
                    inWar = true;
                }
                else if(compare > 0) {
                    // player 1 has higher card
                    copyAndClear(tableQ, player1Q);
                }
                else {
                    // player 2 has higher card
                    copyAndClear(tableQ, player2Q);
                }
            }
        }
        out.printf("Case #%d: %d\n", testNumber, moveCount);
    }

    private int copyAndClear(LinkedList<Card> source, LinkedList<Card> dest) {
        for(int i = source.size()-1; i >= 0; i--) {
            dest.push(source.get(i));
        }
        int result = source.size();
        source.clear();
        return result;
    }
}
