package com.igorgoose.leetcode.java.easy;

// 14. Longest Common Prefix
// Write a function to find the longest common prefix string amongst an array of strings.
//
// If there is no common prefix, return an empty string "".
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        return findInSpan(strs, 0, strs.length);
    }

    public String findInSpan(String[] strs, int start, int end) {
        if (end - start == 1) return strs[start];
        if (end - start == 2) {
            return commonPrefix(strs[start], strs[end - 1]);
        }

        int middle = (start + end) / 2;
        return commonPrefix(findInSpan(strs, middle, end), findInSpan(strs, start, middle));
    }

    public String commonPrefix(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, minLen);
    }
}
