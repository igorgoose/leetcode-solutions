package com.igorgoose.leetcode.java.medium;

import java.util.*;

/*
2250. Count Number of Rectangles Containing Each Point
You are given a 2D integer array rectangles where rectangles[i] = [li, hi] indicates that ith rectangle has a length of li and a height of hi. You are also given a 2D integer array points where points[j] = [xj, yj] is a point with coordinates (xj, yj).

The ith rectangle has its bottom-left corner point at the coordinates (0, 0) and its top-right corner point at (li, hi).

Return an integer array count of length points.length where count[j] is the number of rectangles that contain the jth point.

The ith rectangle contains the jth point if 0 <= xj <= li and 0 <= yj <= hi. Note that points that lie on the edges of a rectangle are also considered to be contained by that rectangle.
 */
public class CountRectanglesContainingPoints {


    void add(int[] ftree, int height) {
        while (height < ftree.length) {
            ftree[height]++;
            height += height & (~height + 1);
        }
    }

    int findLowerOrEqual(int[] ftree, int height) {
        int sum = ftree[0];
        while (height > 0) {
            sum += ftree[height];
            height &= height - 1;
        }
        return sum;
    }

    // rects: {10, 3}, {7, 1}, {5, 2}, {5, 9}, {2, 6}, {2, 4}, {1, 4}
    // points: {10, 3} {8, 10}, {8, 5}, {7, 10}, {6, 6} {5, 4} {3, 6} {2, 3}
    //
    public int[] countRectangles(int[][] rects, int[][] p) {
        int[][] points = new int[p.length][];
        for (int i = 0; i < p.length; i++) {
            points[i] = new int[]{p[i][0], p[i][1], i};
        }
        int[] ftree = new int[101];
        int[] answer = new int[points.length];

        Arrays.sort(rects, (a, b) -> b[0] - a[0]);
        Arrays.sort(points, (a, b) -> b[0] - a[0]);

        int i = 0;
        for (int[] point: points) {
            while(i < rects.length && rects[i][0] >= point[0]) {
                add(ftree, rects[i][1]);
                i++;
            }
            answer[point[2]] = findLowerOrEqual(ftree, 100) - findLowerOrEqual(ftree, point[1] - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] rectangles = new int[][]{
                {7, 1}, {2, 6}, {1, 4}, {5, 2}, {10, 3}, {2, 4}, {5, 9}
        };
        int[][] points = new int[][]{
                {10, 3}, {8, 10}, {2, 3}, {5, 4}, {8, 5}, {7, 10}, {6, 6}, {3, 6}
        };
        for (int i = 0; i < 17; i++) {
            System.out.printf("%d: %s & %s -> %s(%d)%n", i, Integer.toBinaryString(i), Integer.toBinaryString(-i), Integer.toBinaryString(i & (-i)), i & -i);
        }
        System.out.println(Integer.toBinaryString(-10));
        System.out.println(Arrays.toString(new CountRectanglesContainingPoints().countRectangles(rectangles, points)));
    }
}
