package com.igorgoose.leetcode.java.misc;

/*
    f[] - array of numbers
    arr[] - array representing Fenwick tree

    sum(i) = f[0] + ... + f[i]
    sum(i) = sum{i[j] > 0, i[j] = i[j - 1] & (i[j - 1] - 1), i[0] = i}(arr[i[j]]) + arr[0]
    sum(010110) = arr[010110] + arr[010100] + arr[010000] + arr[0]

    arr[10] = f[11] + f[10] + f[01] + f[00]

    1 -> 2 -> 4 -> 8
    3 -> 4
    5 -> 6
    6 -> 8
    7 -> 8

    sum(4) = arr[4] + arr[0]
    sum(3) = arr[3] + arr[2] + arr[0] = f[3] + f[2] + f[1] + f[0]
    arr[0] = f[0]
    arr[2] = f[2] + f[1]
    arr[3] = f[3]

    sum(7) = arr[7] + arr[6] + arr[4] + arr[0]
    arr[4] = f[4] + f[3] + f[2] + f[1] = f[4] + arr[3] + arr[2]
    arr[6] = f[6] + f[5] = f[6] + arr[5]
    arr[7] = f[7]

    16 ____
    | \  \ \
    |  \  \ \
    8  12 14 15
    |\ \
    4 6 7
 */
public class FenwickTree {
    private final int[] arr;

    public FenwickTree(int maxIdx) {
        arr = new int[maxIdx + 1];
    }

    // add(010110, 1)
    // arr[010110]++
    // arr[011000]++
    // arr[100000]++
    // 010110 ->~ 101001 ->+1 101010
    // 010110 & 101010 = 000010
    public void add(int index, int value) {
        while (index < arr.length) {
            arr[index] += value;
            index += index & (~index + 1);
        }
    }

    // lookup(10110) = arr[10110] + arr[10100] + arr[10000]
    // 010110 [-1]-> 010101
    //
    // index &= index - 1
    public int lookup(int index) {
        int sum = arr[0];
        while (index > 0) {
            sum += arr[index];
            index &= index - 1;
        }
        return sum;
    }

//    public static void main(String[] args) {
//        FenwickTree t = new FenwickTree(16);
//        System.out.println(t.lookup(16));
//        t.add(8, 1);
//        t.add(10, 2);
//        t.add(16, 1);
//        System.out.println(t.lookup(7));
//        System.out.println(t.lookup(8));
//        System.out.println(t.lookup(9));
//        System.out.println(t.lookup(10));
//        System.out.println(t.lookup(11));
//        System.out.println(t.lookup(12));
//        System.out.println(t.lookup(13));
//        System.out.println(t.lookup(14));
//        System.out.println(t.lookup(15));
//        System.out.println(t.lookup(16));
//    }
}
