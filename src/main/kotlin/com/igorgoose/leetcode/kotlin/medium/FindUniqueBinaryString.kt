package com.igorgoose.leetcode.kotlin.medium

class FindUniqueBinaryString {
    fun findDifferentBinaryString(nums: Array<String>): String {
        return buildString {
            nums.forEachIndexed { index, s -> append(if (s[index] == '1') '0' else '1') }
        }
    }
}