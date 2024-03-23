package com.igorgoose.leetcode.kotlin.hard

import kotlin.math.max

//32. Longest Valid Parentheses
//Hard
//Topics
//Companies
//Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
//substring
//.
//Example 1:
//
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
//Example 2:
//
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
//Example 3:
//
//Input: s = ""
//Output: 0
//
// ( ) ( ( ( ) ) ( ) )
// 0 2 0 0 0 2
// 0 1 2 3 4 5 6 7
//   2     2 4
// -1 -2 2
// )()())
class LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        val stack = ArrayDeque<Int>(s.length)

        s.forEachIndexed { i, c ->
            when {
                c == '(' -> stack.addFirst(i)
                else -> {
                    if (stack.isNotEmpty() && s[stack.first()] == '(') {
                        stack.removeFirst()
                    } else {
                        stack.addFirst(i)
                    }
                }
            }
        }

        if (stack.isEmpty()) return s.length

        var maxLen = s.length - stack.first() - 1
        var prev = 0

        stack.forEach { idx ->
            maxLen = max(maxLen, prev - idx - 1)
            prev = idx
        }

        return max(maxLen, prev)
    }
}