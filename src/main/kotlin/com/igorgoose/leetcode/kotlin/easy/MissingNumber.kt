package com.igorgoose.leetcode.kotlin.easy

//268. Missing Number
//Easy
//Topics
//Companies
//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        val n = nums.size + 1
        val expectedSum = n * (n + 1) / 2
        return expectedSum - nums.sum()
    }
}