package com.igorgoose.leetcode.java.easy;

import java.util.ArrayList;
import java.util.List;

/*
448. Find All Numbers Disappeared in an Array
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 */
public class FindAllNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean[] found = new boolean[n];
        ArrayList<Integer> result = new ArrayList<>(n / 4);
        for (int num : nums) found[num - 1] = true;
        for (int i = 0; i < n; i++) {
            if (!found[i]) result.add(i + 1);
        }

        return result;
    }
}
