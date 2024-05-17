package com.igorgoose.leetcode.java.medium;

import java.util.ArrayList;
import java.util.List;

/*
39. Combination Sum
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of
candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>(75);
        combinations(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private void combinations(int[] candidates, int target, int curIdx, ArrayList<List<Integer>> result, ArrayList<Integer> curNumbers) {
        if (target == 0) {
            result.add(new ArrayList<>(curNumbers));
            return;
        }

        if (curIdx == candidates.length) return;

        combinations(candidates, target, curIdx + 1, result, curNumbers);

        int i = 1;
        var candidate = candidates[curIdx];
        while (target >= i * candidate) {
            curNumbers.add(candidate);
            combinations(candidates, target - i * candidate, curIdx + 1, result, curNumbers);
            i++;
        }
        while(!curNumbers.isEmpty() && curNumbers.get(curNumbers.size() - 1) == candidate) curNumbers.remove(curNumbers.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
