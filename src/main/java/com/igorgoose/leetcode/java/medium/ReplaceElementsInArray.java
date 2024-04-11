package com.igorgoose.leetcode.java.medium;

/*

2295. Replace Elements in an Array
You are given a 0-indexed array nums that consists of n distinct positive integers. Apply m operations to this array, where in the ith operation you replace the number operations[i][0] with operations[i][1].
It is guaranteed that in the ith operation:
operations[i][0] exists in nums.
operations[i][1] does not exist in nums.
Return the array obtained after applying all the operations.
 */
public class ReplaceElementsInArray {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int[] indexes = new int[1000001];
        for (int i = 0; i < nums.length; i++) indexes[nums[i]] = i;
        for (int[] operation : operations) {
            int index = indexes[operation[0]];
            nums[index] = operation[1];
            indexes[operation[1]] = index;
        }
        return nums;
    }
}
