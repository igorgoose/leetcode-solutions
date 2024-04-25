package com.igorgoose.leetcode.java.medium;

import com.igorgoose.leetcode.java.input.TreeNode;

/*
129. Sum Root to Leaf Numbers
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.
 */
public class SumRootLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode node, int curSum) {
        curSum = curSum * 10 + node.val;
        if (node.left == null && node.right == null) return curSum;

        int res = 0;
        if (node.left != null) res += sum(node.left, curSum);
        if (node.right != null) res += sum(node.right, curSum);

        return res;
    }
}
