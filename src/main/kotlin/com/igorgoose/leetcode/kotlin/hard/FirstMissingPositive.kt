package com.igorgoose.leetcode.kotlin.hard

//41. First Missing Positive
//Hard
//Topics
//Companies
//Hint
//Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
//
//You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
/*
Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.

001
010 missing
011 missing
100
101
110
111

 */
class FirstMissingPositive {
    fun firstMissingPositive(nums: IntArray): Int {
        var i = 0
        while (i < nums.size) {
            val num = nums[i]
            if (num > 0 && num <= nums.size && num != nums[num - 1] && num != i + 1) {
                val temp = nums[num - 1]
                nums[num - 1] = num
                nums[i] = temp
            } else {
                i++
            }
        }

        for (i in nums.indices) {
            if (nums[i] != i + 1) return i + 1
        }

        return nums.size + 1
    }
}

fun main() {
    println(FirstMissingPositive().firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))
}