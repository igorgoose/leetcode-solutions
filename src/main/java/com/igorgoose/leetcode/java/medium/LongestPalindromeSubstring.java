package com.igorgoose.leetcode.java.medium;

/*
5. Longest Palindromic Substring
Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromeSubstring {
    // Manachers's algorithm
    public String longestPalindromeManachers(String s) {
        String ss = preprocess(s);
        char[] charss = ss.toCharArray();

        int n = charss.length;
        int[] rads = new int[n];
        int l = 0, r = 1;

        for (int i = 1; i < n - 1; i++) {
            int mirror = l + r - i;
            if (i < r) rads[i] = Math.min(r - i, rads[mirror]);

            while (
                    i + rads[i] < n &&
                            i - rads[i] >= 0 &&
                            charss[i + rads[i]] == charss[i - rads[i]]
            ) rads[i]++;

            if (i + rads[i] > r) {
                l = i - rads[i];
                r = i + rads[i];
            }
        }

        int maxPalindromeCenter = 1;
        for (int i = 2; i < n - 1; i++) {
            if (rads[i] > rads[maxPalindromeCenter]) maxPalindromeCenter = i;
        }

        int maxRad = rads[maxPalindromeCenter];
        char[] result = new char[maxRad - 1];
        int j = 0;
        for (int i = maxPalindromeCenter - maxRad + 2; i < maxPalindromeCenter + maxRad - 1; i++) {
            if (charss[i] != '|') result[j++] = charss[i];
        }

        return new String(result);
    }

    private String preprocess(String s) {
        char[] chars = new char[s.length() * 2 + 1];
        for (int i = 0; i < s.length(); i++) {
            chars[2 * i] = '|';
            chars[2 * i + 1] = s.charAt(i);
        }
        chars[s.length() * 2] = '|';
        return new String(chars);
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int center = 0;
        int radius = 1;
        boolean even = false;

        for (int i = 0; i < n; i++) {
            int curRadius = findRadiusOdd(i, chars, n);
            if (curRadius > radius) {
                radius = curRadius;
                center = i;
                even = false;
            }

            curRadius = findRadiusEven(i, chars, n);
            if (curRadius >= radius) {
                radius = curRadius;
                center = i;
                even = true;
            }
        }

        return even ? s.substring(center - radius, center + radius) : s.substring(center - radius + 1, center + radius);
    }

    private int findRadiusOdd(int i, char[] chars, int n) {
        int radius = 1;
        while (i - radius >= 0 && i + radius < n &&
                chars[i - radius] == chars[i + radius])
            radius++;
        return radius;
    }

    private int findRadiusEven(int i, char[] chars, int n) {
        int radius = 0;
        while (i - radius - 1 >= 0 && i + radius < n &&
                chars[i - radius - 1] == chars[i + radius])
            radius++;
        return radius;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeSubstring().longestPalindrome("bb"));
    }
}
