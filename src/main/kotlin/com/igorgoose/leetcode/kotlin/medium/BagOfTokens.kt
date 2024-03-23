package com.igorgoose.leetcode.kotlin.medium

import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor
import kotlin.math.max

//948. Bag of Tokens
//You start with an initial power of power, an initial score of 0, and a bag of tokens given as an integer array tokens, where each tokens[i] donates the value of tokeni.
//
//Your goal is to maximize the total score by strategically playing these tokens. In one move, you can play an unplayed token in one of the two ways (but not both for the same token):
//
//Face-up: If your current power is at least tokens[i], you may play tokeni, losing tokens[i] power and gaining 1 score.
//Face-down: If your current score is at least 1, you may play tokeni, gaining tokens[i] power and losing 1 score.
//Return the maximum possible score you can achieve after playing any number of tokens.
class BagOfTokens {

    // [10, 20, 21, 22]
    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        if (tokens.isEmpty()) return 0

        tokens.sort()
        return solveBetween(0, tokens.size - 1, tokens, power, tokens.sum())
    }

    fun solveBetween(left: Int, right: Int, tokens: IntArray, powerRemaining: Int, sumRemaining: Int): Int {
        if (left > right) return 0
        if (tokens[0] > powerRemaining) return 0
        if (sumRemaining <= powerRemaining) return right - left + 1

        if (right > left && tokens[left] + tokens[left + 1] <= powerRemaining) {
            return 1 + solveBetween(left + 1, right, tokens, powerRemaining - tokens[left], sumRemaining - tokens[left])
        }

        return max(
            1, solveBetween(
                left + 1,
                right - 1,
                tokens,
                powerRemaining + tokens[right] - tokens[left],
                sumRemaining - tokens[right] - tokens[left]
            )
        )
    }
}

@Suppress("UNUSED_EXPRESSION")
fun main() {
//    println(BagOfTokens().bagOfTokensScore(intArrayOf(68, 85, 34, 25, 60), 44))
    Executors.newFixedThreadPool(20).use { executor ->
        repeat(18) {
            executor.submit {
                println("${Thread.currentThread()} sleeping ...")
                Thread.sleep(10000)
                println("${Thread.currentThread()} i'm awake bitch ...")
            }
        }
        executor.submit {
            println("${Thread.currentThread()} wow i'm working for some unknown reason")
        }
    }
}
