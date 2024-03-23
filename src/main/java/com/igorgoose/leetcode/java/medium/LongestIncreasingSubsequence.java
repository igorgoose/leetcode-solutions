package com.igorgoose.leetcode.java.medium;

/*
300. Longest Increasing Subsequence
Given an integer array nums, return the length of the longest strictly increasing
subsequence

[10,9,2,5,3,7,101,18]
m[ , 2, , , , , , , ]
1 3
1 2

2
2 5

4
1 3 5 -> 1 3 4
0 3 -> lo 2
2 3 -> hi 2
lo 2


*/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;

        int maxL = 0;
        int[] m = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            int lo = 1;
            int hi = maxL + 1;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (nums[i] > nums[m[mid]]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            m[lo] = i;
            if (lo > maxL) maxL = lo;
        }

        return maxL;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
