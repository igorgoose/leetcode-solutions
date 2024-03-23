package com.igorgoose.leetcode.java.medium;

// 334. Increasing Triplet Subsequence
// Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
public class IncreasingTripletSubset {

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min1) min1 = num;
            else if (num <= min2) min2 = num;
            else return true;
        }
        return false;
    }
}
