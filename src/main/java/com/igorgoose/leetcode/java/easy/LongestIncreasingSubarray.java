package com.igorgoose.leetcode.java.easy;

/*
674. Longest Continuous Increasing Subsequence
Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.
A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].
 */
public class LongestIncreasingSubarray {

    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int cur = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev < nums[i]) cur++;
            else {
                max = Math.max(max, cur);
                cur = 1;
            }
            prev = nums[i];
        }
        return Math.max(cur, max);
    }
}
