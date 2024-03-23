package com.igorgoose.leetcode.kotlin.hard

import com.igorgoose.leetcode.kotlin.input.ListNode
import com.igorgoose.leetcode.kotlin.input.listAsString
import com.igorgoose.leetcode.kotlin.input.toListNodes

/* 25. Reverse Nodes in k-Group
Hard
Topics
Companies
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
_______________________________________________________________________________________________________________
Notes:

stack [3, 2, 1] - not O(1) space

1 2 3 4 5
1 | 2 -> 3
2 1 3 4 5
2 1 | 3 -> 4
2 1 3 4 5

1 2 3 4 5

1 2
1 2 | 3
2 1 3

3 4 | 5
2 -> 1
     |
4 -> 3 -> 5
_______________________________________________________________________________________________________________

Example:
  var li = ListNode(5)
  var v = li.`val`
  Definition for singly-linked list.
  class ListNode(var `val`: Int) {
      var next: ListNode? = null
  }
*/

class ReverseNodesInKGroupSolution {

    // O(n) time, // O(1) space
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 1) return head
        var newHead = head
        var curHead = head
        var lastPivot: ListNode? = null

        while (curHead != null) {
            var nextHead = curHead.next
            var i = 1
            while (i < k && nextHead != null) {
                nextHead = nextHead.next
                ++i
            }

            if (i < k) return newHead

            val pivot = curHead
            repeat(k - 1) {
                val secondNext = pivot.next!!.next
                pivot.next!!.next = curHead
                curHead = pivot.next
                pivot.next = secondNext
            }

            if (newHead == head) newHead = curHead
            if (lastPivot != null) lastPivot.next = curHead
            lastPivot = pivot

            curHead = pivot.next
        }

        return newHead
    }
}
