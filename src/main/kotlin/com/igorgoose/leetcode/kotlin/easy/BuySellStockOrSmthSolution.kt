package com.igorgoose.leetcode.kotlin.easy

import kotlin.math.max

//Example 1:
//
//Input: prices = [7,1,5,3,6,4]
// [, , , , , ]    6 6 6 6 4 -1
// []
//
// [4, -2, 3, -2]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//Example 2:
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
class BuySellStockOrSmthSolution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var prevMax = -1
        for (i in prices.size - 2 downTo 0) {
           prevMax = max(prices[i + 1], prevMax)
           profit = max(prevMax - prices[i], profit)
        }
        return profit
    }
}