package com.igorgoose.leetcode.java.medium;

/*
678. Valid Parenthesis String
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 */
public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        int diff = 0, starsCount = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            switch(arr[i]) {
                case '(':
                    diff++;
                    break;
                case '*':
                    starsCount++;
                    break;

                case ')':
                    if (diff > 0) {
                        diff--;
                    } else if (starsCount > 0) {
                        starsCount--;
                    } else {
                        return false;
                    }
            }
        }

        diff = 0;
        starsCount = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            switch(arr[i]) {
                case ')':
                    diff++;
                    break;
                case '*':
                    starsCount++;
                    break;

                case '(':
                    if (diff > 0) {
                        diff--;
                    } else if (starsCount > 0) {
                        starsCount--;
                    } else {
                        return false;
                    }
            }
        }

        return true;
    }
}
