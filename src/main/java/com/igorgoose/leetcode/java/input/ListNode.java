package com.igorgoose.leetcode.java.input;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.format("ListNode(%d)", val);
    }

    public static ListNode fromArray(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode cur = new ListNode(arr[i]);
            prev.next = cur;
            prev = cur;
        }
        return head;
    }

    public static String print(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val).append(", ");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
