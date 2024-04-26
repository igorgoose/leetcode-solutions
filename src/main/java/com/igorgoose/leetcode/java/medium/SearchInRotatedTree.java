package com.igorgoose.leetcode.java.medium;

public class SearchInRotatedTree {
    // 6 7 0 1 2 4 5
    // 4 5 6 7 0 1 2
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) return mid;
            if (nums[mid] <= nums[hi - 1]) {
                if (target > nums[mid] && target <= nums[hi - 1]) lo = mid + 1;
                else hi = mid;
            } else {
                if (target < nums[mid] && target >= nums[lo]) hi = mid;
                else lo = mid + 1;
            }
        }

        return lo < nums.length && nums[lo] == target ? lo : -1;
    }

    public int subOptimalSearch(int[] nums, int target) {
        int pivot = searchPivot(nums);

        if (pivot == nums.length) return doSearch(nums, target, 0, nums.length);

        int leftRes = doSearch(nums, target, 0, pivot + 1);
        if (leftRes != -1) return leftRes;
        return doSearch(nums, target, pivot + 1, nums.length);
    }

    private int searchPivot(int[] nums) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) return mid - 1;
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) return mid;

            if (nums[mid] < nums[hi - 1]) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private int doSearch(int[] nums, int target, int lo, int hi) {
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) return mid;
            if (nums[mid] > target) hi = mid;
            else lo = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedTree().search(new int[] {4,5,6,7,0,1,2}, 0));
    }
}
