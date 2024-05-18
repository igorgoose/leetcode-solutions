package com.igorgoose.leetcode.java.easy;

/*
409. Longest Palindrome
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case-sensitive, for example, "Aa" is not considered a palindrome here.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] charCounts = new int[52];

        for (char c : s.toCharArray()) {
            ++charCounts[index(c)];
        }

        boolean oddsPresent = false;
        int sum = 0;
        for (int count : charCounts) {
            if ((count | 1) == count) {
                oddsPresent = true;
                count--;
            }
            sum += count;
        }

        return oddsPresent ? sum + 1 : sum;
    }

    private int index(char c) {
        if (c < 'a') return c - 'A';
        return 26 + c - 'a';
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
    }
}
