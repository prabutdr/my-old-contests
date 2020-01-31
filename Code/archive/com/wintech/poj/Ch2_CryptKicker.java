package com.wintech.poj;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.*;

public class Ch2_CryptKicker {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        int n = Integer.parseInt(in.readLine());
        String line;
        int length;
        int i, j, k;
        HashMap<Integer, ArrayList<String>> dictionary = new HashMap<Integer, ArrayList<String>>(n);
        for(i = 0; i < n; i++) {
            line = in.readLine();
            length = line.length();
            if(dictionary.containsKey(length)) {
                dictionary.get(length).add(line);
            }
            else {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(line);
                dictionary.put(length, temp);
            }
        }
        //out.println("Dictionary: " + dictionary);

        while(!in.isEOF()) {
            TreeSet<String> twords = new TreeSet<String>(new LengthDescComparator());
            line = in.readLine();
            for(String str: line.split("\\s+")) {
                twords.add(str);
            }
            String[] words = new String[1];
            words = twords.toArray(words);
            String[] matchWords = new String[words.length];
            //out.println("Words: " + Arrays.toString(words));

            HashMap<Character, Character> charMap = new HashMap<Character, Character>(26);
            Stack<StackPoint> stack = new Stack<StackPoint>();
            String prevMatchWord = null;

            for(i = 0; i < words.length;) {
                String curWord = words[i];
                ArrayList<String> posWords = dictionary.get(curWord.length());
                if(posWords == null)
                    break;

                for(j = posWords.indexOf(prevMatchWord)+1; j < posWords.size(); j++) {
                    String posWord = posWords.get(j);
                    HashMap<Character, Character> newCharMap = new HashMap<Character, Character>();
                    for(k = 0; k < posWord.length(); k++) {
                        char curWordChar = curWord.charAt(k);
                        char posWordChar = posWord.charAt(k);
                        if(charMap.containsKey(curWordChar)) {
                            if(!charMap.get(curWordChar).equals(posWordChar))
                                break;
                        }
                        else {
                            newCharMap.put(curWordChar, posWordChar);
                        }
                    }
                    if(k == posWord.length()) {
                        charMap.putAll(newCharMap);
                        stack.push(new StackPoint(newCharMap, i));
                        matchWords[i] = posWord;
                        break;
                    }
                }

                if(j == posWords.size()) {
                    if(stack.isEmpty()) {
                        break;
                    }
                    else {
                        StackPoint sp = stack.pop();
                        for(Character ch: sp.charMap.keySet()) {
                            charMap.remove(ch);
                        }
                        i = sp.idx;
                        prevMatchWord = matchWords[i];
                        //matchWords[i] = null;
                    }
                }
                else {
                    prevMatchWord = null;
                    i++;
                }
            }
            //out.println("matchWords: " + Arrays.toString(matchWords));
            if(i == words.length) {
                for(i = 0; i < words.length; i++) {
                    line = line.replaceAll(words[i], matchWords[i]);
                }
                out.println(line);
            }
            else {
                out.println(line.replaceAll("[a-z]", "*"));
            }
        }
    }

    class LengthDescComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }

            return o2.compareTo(o1);
        }
    }

    class StackPoint {
        //String word;
        HashMap<Character, Character> charMap = new HashMap<Character, Character>();
        int idx;

        StackPoint(HashMap<Character, Character> charMap, int idx) {
            //this.word = word;
            this.charMap = charMap;
            this.idx = idx;
        }
    }
}
