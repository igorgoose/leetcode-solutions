package com.igorgoose.leetcode.java.hard;

/*
458. Poor Pigs
There are buckets buckets of liquid, where exactly one of the buckets is poisonous. To figure out which one is poisonous, you feed some number of (poor) pigs the liquid to see whether they will die or not. Unfortunately, you only have minutesToTest minutes to determine which bucket is poisonous.

You can feed the pigs according to these steps:

Choose some live pigs to feed.
For each pig, choose which buckets to feed it. The pig will consume all the chosen buckets simultaneously and will take no time. Each pig can feed from any number of buckets, and each bucket can be fed from by any number of pigs.
Wait for minutesToDie minutes. You may not feed any other pigs during this time.
After minutesToDie minutes have passed, any pigs that have been fed the poisonous bucket will die, and all others will survive.
Repeat this process until you run out of time.
Given buckets, minutesToDie, and minutesToTest, return the minimum number of pigs needed to figure out which bucket is poisonous within the allotted time.

*/
public class PoorPigs {
    // could be improved by caching and using Pascal's triangle i guess
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int tests = minutesToTest / minutesToDie;
        int[] factorials = factorials(buckets);

        int pigs = 1;
        while (buckets(pigs, tests - 1, factorials) < buckets) {
            pigs++;
        }
        return pigs;
    }

    public int buckets(int pigs, int roundsLeft, int[] factorials) {
        if (pigs == 0) return 1;
        if (roundsLeft == 0) return 1 << pigs;

        int sum = 0;
        for (int i = 0; i <= pigs; i++) {
            sum += composition(i, pigs, factorials) * buckets(pigs - i, roundsLeft - 1, factorials);
        }

        return sum;
    }

    public int composition(int k, int n, int[] factorials) {
        if (k == 0 || k == n) return 1;
        return factorials[n] / factorials[k] / factorials[n - k];
    }

    public int[] factorials(int ub) {
        int[] factorials = new int[ub + 1];
        factorials[0] = 1;
        for (int i = 1; i <= ub; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        return factorials;
    }
}
