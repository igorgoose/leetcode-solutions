package com.igorgoose.leetcode.kotlin.hard

class DecodeWays2 {
    fun numDecodings(s: String): Int {
        return solveFrom(0, s, hashMapOf<Int, Long>()).toInt()
    }

    fun solveFrom(index: Int, s: String, prevResults: HashMap<Int, Long>): Long {
        if (index > s.length - 1) return 1
        return prevResults[index] ?: (when (val cur = s[index]) {
            '*' -> {
                9 * solveFrom(index + 1, s, prevResults) +
                        if (index + 1 < s.length) charWays(cur, s[index + 1]) * solveFrom(index + 2, s, prevResults)
                        else 0
            }

            '0' -> 0
            '1', '2' -> {
                solveFrom(index + 1, s, prevResults) +
                        if (index + 1 < s.length) charWays(cur, s[index + 1]) * solveFrom(index + 2, s, prevResults)
                        else 0
            }

            else -> {
                solveFrom(index + 1, s, prevResults)
            }
        } % 1000000007).also {
            prevResults[index] = it
        }
    }

    fun charWays(c: Char, next: Char): Int {
        return when (c) {
            '1' -> {
                if (next == '*') 9
                else 1
            }

            '2' -> {
                when (next) {
                    '*' -> 6
                    in ('0'..'6') -> 1
                    else -> 0
                }
            }

            '*' -> {
                when (next) {
                    '*' -> 15
                    in ('0'..'6') -> 2
                    else -> 1
                }
            }

            else -> error("dsakjflaksjd")
        }
    }
}

fun main() {
    println(DecodeWays2().numDecodings("1*6*7*1*9*6*2*9*2*3*3*6*3*2*2*4*7*2*9*6*0*6*4*4*1*6*9*0*5*9*2*5*7*7*0*6*9*7*1*5*5*9*3*0*4*9*2*6*2*5*7*6*1*9*4*5*8*4*7*4*2*7*1*2*1*9*1*3*0*6*"))





    Absolute::class








}

class Absolute {

}