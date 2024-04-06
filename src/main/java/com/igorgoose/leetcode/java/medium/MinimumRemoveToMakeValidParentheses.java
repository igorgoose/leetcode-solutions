package com.igorgoose.leetcode.java.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;

/*
1249. Minimum Remove to Make Valid Parentheses
Given a string s of '(' , ')' and lowercase English characters.
Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:
It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 */
public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        ArrayList<Integer> rmIdxs = new ArrayList<>();
        rmIdxs.add(-1);
        ArrayDeque<Integer> openIdxs = new ArrayDeque<>();
        int i = 0, len = s.length();
        while (i < len) {
            char c = s.charAt(i);
            switch(c) {
                case '(': {
                    openIdxs.push(i);
                    break;
                }
                case ')': {
                    if (!openIdxs.isEmpty()){
                        openIdxs.pop();
                    } else {
                        rmIdxs.add(i);
                    }
                    break;
                }
            }
            i++;
        }
        while(!openIdxs.isEmpty()) {
            rmIdxs.add(openIdxs.pollLast());
        }
        rmIdxs.add(len);
        StringBuilder sb = new StringBuilder();
        for (int j = 1; j < rmIdxs.size(); j++) {
            for (int k = rmIdxs.get(j - 1) + 1; k < rmIdxs.get(j); k++) {
                sb.append(s.charAt(k));
            }
        }
        return sb.toString();
    }
}
