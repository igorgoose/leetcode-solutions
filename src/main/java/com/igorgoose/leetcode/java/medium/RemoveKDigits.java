package com.igorgoose.leetcode.java.medium;

import java.util.ArrayDeque;

/*
402. Remove K Digits
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>(chars.length);

        for (char c : chars) {
            while (k > 0 && !stack.isEmpty() && c < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        boolean skipZeros = true;
        while (!stack.isEmpty()) {
            char c = stack.removeLast();
            if (!skipZeros || c != '0') {
                sb.append(c);
            }
            if (c != '0') skipZeros = false;
        }
        String res = sb.toString();
        return res.isEmpty() ? "0" : res;
    }
}
