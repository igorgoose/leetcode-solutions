package com.igorgoose.leetcode.java.medium;

import com.igorgoose.leetcode.java.input.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2476. Closest Nodes Queries in a Binary Search Tree
You are given the root of a binary search tree and an array queries of size n consisting of positive integers.

Find a 2D array answer of size n where answer[i] = [mini, maxi]:

mini is the largest value in the tree that is smaller than or equal to queries[i]. If a such value does not exist, add -1 instead.
maxi is the smallest value in the tree that is greater than or equal to queries[i]. If a such value does not exist, add -1 instead.
Return the array answer.
 */
public class ClosesNodesQueries {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>(queries.size());

        List<Integer> list = new ArrayList<>(500);
        inOrder(root, list);
        int[] values = new int[list.size()];
        for (int i = 0; i < list.size(); i++) values[i] = list.get(i);

        for (Integer query : queries) {
            result.add(search(values, query));
        }
        return result;
    }

    private void inOrder(TreeNode node, List<Integer> array) {
        if (node == null) return;

        inOrder(node.left, array);
        array.add(node.val);
        inOrder(node.right, array);
    }

    private List<Integer> search(int[] values, int query) {
        Integer[] result = new Integer[] {-1, -1};

        int l = 0;
        int r = values.length;
        while (l < r) {
            int mid = (l + r) / 2;
            int midValue = values[mid];
            if (midValue == query) {
                result[0] = query;
                result[1] = query;
                return Arrays.asList(result);
            }
            if (midValue > query) {
                if (result[1] == -1) {
                    result[1] = midValue;
                } else {
                    result[1] = Math.min(midValue, result[1]);
                }
                r = mid;
                continue;
            }

            if (result[0] == -1) {
                result[0] = midValue;
            } else {
                result[0] = Math.max(midValue, result[0]);
            }
            l = mid + 1;
        }

        return Arrays.asList(result);
    }
}
