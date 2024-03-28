package com.igorgoose.leetcode.java.medium;

import java.util.HashMap;

/*
2958. Length of Longest Subarray With at Most K Frequency
You are given an integer array nums and an integer k.

The frequency of an element x is the number of times it occurs in an array.

An array is called good if the frequency of each element in this array is less than or equal to k.

Return the length of the longest good subarray of nums.

A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class LengthOfLongestSubarrayWithAtMostKFrequency {
    //[1,1,2]
    // 0 1 2 3 4 5 6 7
    // [1, 1] k=2
    public int maxSubarrayLength(int[] nums, int k) {
        int l = 0, r = 0;
        int freq = 0;
        int max = 0;

        HashMap<Integer, Integer> freqsMap = new HashMap<>();
        while (r < nums.length) {
            while (freq <= k && r < nums.length) {
                Integer curFreq = freqsMap.get(nums[r]);
                curFreq = curFreq == null ? 1 : curFreq + 1;
                freq = curFreq > freq ? curFreq : freq;
                freqsMap.put(nums[r++], curFreq);
            }
            if (freq > k) max = r - l - 1 > max ? r - l - 1: max;
            else max = r - l > max ? r - l : max;
            while (freq > k) {
                int curFreq = freqsMap.get(nums[l]);
                if (curFreq == freq) freq--;
                freqsMap.put(nums[l++], --curFreq);
            }
        }
        return max;
    }
}
