package com.igorgoose.leetcode.java.hard;

import java.util.Arrays;

/*
2407. Longest Increasing Subsequence II
You are given an integer array nums and an integer k.

Find the longest subsequence of nums that meets the following requirements:

The subsequence is strictly increasing and
The difference between adjacent elements in the subsequence is at most k.
Return the length of the longest subsequence that meets the requirements.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

*/
public class LongestIncreasingSubsequence2 {

    public int lengthOfLIS(int[] nums, int k) {
        int maxLen = 0;
        int[] m = new int[nums.length + 1];
        Arrays.asList(m);

        for (int i = 0; i < nums.length; i++) {
            int lo = 1;
            int hi = maxLen + 1;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (nums[m[mid]] < nums[i]) lo = mid + 1;
                else hi = mid;
            }

            m[lo] = i;
            if (lo > maxLen) maxLen = lo;
        }

        return maxLen;
    }
}
