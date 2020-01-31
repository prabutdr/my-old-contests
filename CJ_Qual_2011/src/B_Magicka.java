/*
 * To change this B_Magicka, choose Tools | B_Magickas
 * and open the B_Magicka in the editor.
 */

/**
 * @date 06-May-2011
 * @author Prabu
 */

import java.io.*;
import java.util.*;

public class B_Magicka {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            B_Magicka solver = new B_Magicka();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "B-large";
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
        int tc = sc.nextInt(); sc.nextLine();
        int cmbCount, opposeCount, i, elementCount;
        String token, lastCombin;
        StringTokenizer tokens;
        HashMap<String, Character> combinations;
        HashMap<Character, HashSet<Character>> opponants;
        ArrayList<Character> elements;
        Character element, lastElement;
        //HashSet<Character> opponant;

        for(int tci = 1; tci <= tc; tci++) {
            tokens = new StringTokenizer(sc.nextLine(), " ");

            cmbCount = Integer.parseInt(tokens.nextToken());
            combinations = new HashMap<String, Character>();
            for(i = 0; i < cmbCount; i++) {
                token = tokens.nextToken();
                if(token.charAt(0) < token.charAt(1)) {
                    combinations.put(token.substring(0, 2), token.charAt(2));
                }
                else {
                    combinations.put(token.charAt(1) + "" + token.charAt(0), token.charAt(2));
                }
            }
            //System.out.println("Combs: " + combinations);

            opposeCount = Integer.parseInt(tokens.nextToken());
            opponants = new HashMap<Character, HashSet<Character>>();
            for(i = 0; i < opposeCount; i++) {
                token = tokens.nextToken();
                addOpponent(opponants, token.charAt(0), token.charAt(1));
                addOpponent(opponants, token.charAt(1), token.charAt(0));
            }
            //System.out.println("Opponents: " + opponants);

            elementCount = Integer.parseInt(tokens.nextToken());
            token = tokens.nextToken();
            elements = new ArrayList<Character>();
            for(i = 0; i < elementCount; i++) {
                if(elements.isEmpty()) {
                    elements.add(token.charAt(i));
                    continue;
                }

                lastElement = elements.get(elements.size() - 1);
                element = token.charAt(i);
                if(element > lastElement) {
                    lastCombin = lastElement.toString() + element;
                }
                else {
                    lastCombin = element.toString() + lastElement;
                }
                if(combinations.containsKey(lastCombin)) {
                    elements.set(elements.size() - 1, combinations.get(lastCombin));
                    continue;
                }

                if(opponants.get(element) != null && elements.removeAll(opponants.get(element))) {
                    elements.clear();
                    continue;
                }
                elements.add(element);
            }
            out.println("Case #" + tci + ": " + elements);
        }
    }

    private void addOpponent(HashMap<Character, HashSet<Character>> set, Character key, Character value) {
        if(!set.containsKey(key))
            set.put(key, new HashSet<Character>());
        set.get(key).add(value);
    }
/******************************************************************************/
}
