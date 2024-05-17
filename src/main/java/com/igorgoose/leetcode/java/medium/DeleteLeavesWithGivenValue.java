package com.igorgoose.leetcode.java.medium;

import com.igorgoose.leetcode.java.input.TreeNode;

/*
1325. Delete Leaves With a Given Value
Given a binary tree root and an integer target, delete all the leaf nodes with value target.

Note that once you delete a leaf node with value target, if its parent node becomes a leaf node and has the value target,
it should also be deleted (you need to continue doing that until you cannot).
 */
public class DeleteLeavesWithGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left != null) root.left = removeLeafNodes(root.left, target);
        if (root.right != null) root.right = removeLeafNodes(root.right, target);

        if (root.right == null && root.left == null && root.val == target) return null;
        return root;
    }
}
