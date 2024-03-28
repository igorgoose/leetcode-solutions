package com.igorgoose.leetcode.java.medium;

/*
713. Subarray Product Less Than K
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

Example 1:

Input: nums = [10,5,2,6], k = 100
2
4
2
1

(1 + 3) / 2 * 3
(r - l) * (r - l - 1) / 2
r = 4; l = 1

Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0
0  1 2 3 4 5 6 7 8 9
10,2,2,5,4,4,4,3,7,7  k=289
l=0; r=5 cur=800 ans+=4
l=1; r=6 cur=320 ans+=4
l=2; r=7 cur=640 ans+=4 +=3
l=4; r=9 cur=192*7  ans+=4 +=3
l=6; r=10 cur=84*7  ans+=3
l=7; r=10 cur=147 ans+=6
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int l = 0, r = 0, ans = 0, cur = 1;
        while (r < nums.length) {
            while (r < nums.length && cur < k) {
                cur *= nums[r++];
            }
            while (cur >= k) {
                cur /= nums[l++];
                if (r > l) {
                    ans += (r - l);
                }
            }
        }
        ans += (r - l + 1) * (r - l) / 2;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
}
