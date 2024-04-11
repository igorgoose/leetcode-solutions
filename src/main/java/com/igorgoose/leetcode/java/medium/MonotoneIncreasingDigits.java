package com.igorgoose.leetcode.java.medium;

/*
738. Monotone Increasing Digits
An integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.
Given an integer n, return the largest number that is less than or equal to n with monotone increasing digits.
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        if (n < 10) return n;
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;

        int i = 0;
        while (i < len - 1 && digits[i] <= digits[i + 1]) i++;
        if (i == len - 1) return n;

        int j = len - 1;
        while (j > i || j > 0 && digits[j] <= digits[j - 1]) digits[j--] = '9';
        digits[j]--;

        return Integer.parseInt(new String(digits));
    }
}
