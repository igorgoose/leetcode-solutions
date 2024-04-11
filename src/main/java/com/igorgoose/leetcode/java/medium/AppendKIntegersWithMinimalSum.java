package com.igorgoose.leetcode.java.medium;

import java.util.Arrays;

/*
2195. Append K Integers With Minimal Sum
You are given an integer array nums and an integer k. Append k unique positive integers that do not appear in nums to nums such that the resulting total sum is minimum.
Return the sum of the k integers appended to nums.
 */
public class AppendKIntegersWithMinimalSum {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        long sum = sumBetween(0, nums[0], k);
        k -= nums[0] - 1;
        int i = 1;
        while (i < nums.length && k > 0) {
            if (nums[i] != nums[i - 1]) {
                sum += sumBetween(nums[i - 1], nums[i], k);
                k -= nums[i] - nums[i - 1] - 1;
            }
            i++;
        }

        if (k > 0) sum += sumBetween(nums[nums.length - 1], Integer.MAX_VALUE, k);

        return sum;
    }

    private long sumBetween(long left, long right, int k) {
        right = Math.min(right, left + k + 1);
        return (left + right) * (right - left - 1) / 2;
    }
}
