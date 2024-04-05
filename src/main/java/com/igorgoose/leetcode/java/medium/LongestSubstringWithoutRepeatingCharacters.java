package com.igorgoose.leetcode.java.medium;

import java.util.HashSet;

/*
3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        HashSet<Character> found = new HashSet<Character>();

        int r = 0, l = 0, max = 1;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (!found.contains(c)) {
                found.add(c);
                r++;
                continue;
            }
            max = Math.max(r - l, max);
            char removed;
            do {
                removed = s.charAt(l++);
                found.remove(removed);
            } while (c != removed);
        }
        return Math.max(r - l, max);
    }
}
