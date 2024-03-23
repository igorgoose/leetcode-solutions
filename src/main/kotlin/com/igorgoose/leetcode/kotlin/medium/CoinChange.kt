package com.igorgoose.leetcode.kotlin.medium

import kotlin.math.min

/*
322. Coin Change

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
*/

class CoinChangeSolution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        val mins = IntArray(amount + 1) { if (it == 0) 0 else Integer.MAX_VALUE }

        for (i in 1..amount) {
            coins.forEach { coin ->
                if (i - coin >= 0 && mins[i - coin] != Integer.MAX_VALUE) {
                    mins[i] = min(mins[i], mins[i - coin] + 1)
                }
            }
        }

        return if (mins[amount] == Integer.MAX_VALUE) -1 else mins[amount]
    }

}

//fun main() {
//    val solution = CoinChangeSolution()
//    println(
//        solution.coinChange(intArrayOf(1), 0)
//    )
//}