package com.wintech.util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: Prabu
 * Date: 3/24/12 8:57 PM
 */
public class StringUtil {

    // To determine whether given string is palindrome
    public static boolean isPalindrome(String s) {
        int mid = s.length() / 2;
        
        for(int i = 0; i < mid; i++) {
            if(s.charAt(i) != s.charAt(s.length()-(i+1)))
                return false;
        }

        return true;
    }

    // Check whether an array of strings is in alphabetical order
    public static boolean isSorted(String[] a) {
        for (int i = 1; i < a.length; i++) {
            if(a[i-1].compareTo(a[i]) > 0)
                return false;
        }
        return true;
    }

    // Determine whether two given strings are circular match (initial version)
    public static boolean isCircularMatch(String a, String b) {
        if(a.length() != b.length()) return false;

        for(int i = 0; i < a.length(); i++) {
            String tmp = b.substring(i);
            if(a.startsWith(tmp) && a.equals(tmp + b.substring(0, i))) {
                //System.out.println("Step count - " + i);
                return true;
            }
        }

        return false;
    }

    public static ArrayList<String> findPermutations(String input) {
        char[] text = input.toCharArray();
        int i, j, largeIdx;
        int temp;
        ArrayList<String> result = new ArrayList<String>();

        Arrays.sort(text);  // sort given char array
        int[] chOrder = new int[text.length];   // order array to determine position of each character
        for(i = 0; i < text.length; i++) {      // define initial order 0 to length - 1
            chOrder[i] = i;
        }

        result.add(toStringPerOrder(text, chOrder));       // add first combination

        for(i = chOrder.length - 2; i >= 0; i--) {    // start from end of string
            largeIdx = findNextLargeElementStartIdx(chOrder[i], chOrder, i+1, chOrder.length-1);
            if(largeIdx != -1) {
                // if any next large element is found, then swap those values, print that, and start again.
                temp = chOrder[i];
                chOrder[i] = chOrder[largeIdx];
                chOrder[largeIdx] = temp;

                result.add(toStringPerOrder(text, chOrder));           // print current order of chars
                i = chOrder.length - 1;                     // start from end of string again
            }
            else if(chOrder[i] > chOrder[i+1]) {
                // if there are no large value found after current position, place current value to appropriate
                // place (so that portion of array will be sorted) and move backward for next set of combination.
                for(j = i; j < chOrder.length-1 && chOrder[j] > chOrder[j+1]; j++) {
                    temp = chOrder[j];
                    chOrder[j] = chOrder[j+1];
                    chOrder[j+1] = temp;
                }
            }
        }
        return result;
    }

    /**
     * Print characters as per given order
     */
    private static String toStringPerOrder(char[] text, int[] chOrder) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chOrder.length; i++) {
            sb.append(text[chOrder[i]]);
        }
        return sb.toString();
    }

    /**
     * Find count of elements larger than given key using binary search
     */
    private static int findNextLargeElementStartIdx(int key, int[] array, int li, int hi) {
        int maxIdx = hi;
        int rank = 0;
        while(li <= hi) {
            rank = li + (hi - li) / 2;
            if(array[rank] < key)
                li = rank + 1;
            else if(array[rank] > key)
                hi = rank - 1;
            else
                break;
        }

        if(li <= hi) { // key found at rank pos, then eliminate equivalent to key
            do {
                rank++;
            }
            while(rank < array.length && array[rank] == key);
        }
        else {  // key not found
            rank = li;
        }

        if(rank > maxIdx)
            return -1;
        else
            return li;
    }

    // Test client
    public static void main(String[] args) {
        System.out.println("isPalindrome(\"AbbA\")" + isPalindrome("AbbA"));
        System.out.println("isPalindrome(\"Ab\")" + isPalindrome("Ab"));
        System.out.println("isPalindrome(\"AbA\")" + isPalindrome("AbA"));
        System.out.println("isPalindrome(\"AbC\")" + isPalindrome("AbC"));
        System.out.println("isPalindrome(\"AcbA\")" + isPalindrome("AbcA"));
        System.out.println("isPalindrome(\"AbcA\")" + isPalindrome("AbcA"));
        System.out.println("isPalindrome(\"unknown text\")" + isPalindrome("unknown text"));
        
        String[] array = {"Gopal", "Arun", "Raja", "Ragul"};
        System.out.printf("\n%s is sorted array - %b\n", Arrays.toString(array), isSorted(array));
        Arrays.sort(array);
        System.out.printf("\n%s is sorted array - %b\n", Arrays.toString(array), isSorted(array));

        System.out.println("isCircularMatch(\"ACTGACG\", \"TGACGAC\"): " + isCircularMatch("ACTGACG", "TGACGAC"));
        System.out.println("isCircularMatch(\"TGACGAC\", \"ACTGACG\"): " + isCircularMatch("TGACGAC", "ACTGACG"));
        System.out.println("isCircularMatch(\"AAAAABAAAA\", \"AABAAAAAAA\"): " + isCircularMatch("AAAAABAAAA", "AABAAAAAAA"));
        System.out.println("isCircularMatch(\"AABAAAAAAA\", \"AAAAABAAAA\"): " + isCircularMatch("AABAAAAAAA", "AAAAABAAAA"));
        System.out.println("isCircularMatch(\"Prabhakar\", \"bhakarPra\"): " + isCircularMatch("Prabhakar", "bhakarPra"));
        System.out.println("isCircularMatch(\"Prabhakar\", \"Prabhakar\"): " + isCircularMatch("Prabhakar", "Prabhakar"));
        System.out.println("isCircularMatch(\"test\", \"testone\"): " + isCircularMatch("test", "testone"));
        System.out.println("isCircularMatch(\"aaaB\", \"bAAA\"): " + isCircularMatch("aaaB", "bAAA"));
    }
}
