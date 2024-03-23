package com.igorgoose.leetcode.java.medium;

import com.igorgoose.leetcode.java.input.ListNode;

// 143. Reorder List
// You are given the head of a singly linked-list. The list can be represented as:
//
// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
//
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head.next == null) return;

        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        int secondHeadIdx = count % 2 == 0 ? count / 2 : count / 2 + 1;
        ListNode secondHead = head;
        for (int i = 0; i < secondHeadIdx; i++) {
            secondHead = secondHead.next;
        }

        secondHead = reverse(secondHead);
        cur = head;
        while (secondHead != null) {
            ListNode temp = cur.next;
            cur.next = secondHead;
            secondHead = secondHead.next;
            cur.next.next = temp;
            cur = temp;
        }
        cur.next = null;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = head;
        while (head.next != null) {
            ListNode toMove = head.next;
            head.next = head.next.next;
            toMove.next = newHead;
            newHead = toMove;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[] {1,2,3,4,5});
        new ReorderList().reorderList(head);
        System.out.println(ListNode.print(head));
    }
}
