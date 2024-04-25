package com.igorgoose.leetcode.java.hard;

/*
42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
*/
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = 0;
        maxRight[n - 1] = 0;

        for (int i = 1; i < n; i++) maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        for (int i = n - 2; i >= 0; i--) maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);

        int sum = 0;
        for (int i = 0; i < n; i++) sum += Math.max(0, Math.min(maxLeft[i], maxRight[i]) - height[i]);

        return sum;
    }
}
