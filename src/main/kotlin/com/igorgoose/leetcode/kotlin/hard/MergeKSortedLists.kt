package com.igorgoose.leetcode.kotlin.hard

import com.igorgoose.leetcode.kotlin.input.ListNode
import java.util.*

/*
23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]


merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.


 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class MergeKSortedListsSolution {
    // O(kn * k)
    fun mergeKListsSlow(lists: Array<ListNode?>): ListNode? {
        var root: ListNode? = null
        var last: ListNode? = null

        while (true) {
            var minIdx = -1

            lists.forEachIndexed { idx, node ->
                if (node != null && (minIdx == -1 || node.`val` < lists[minIdx]!!.`val`)) {
                    minIdx = idx
                }
            }

            if (minIdx == -1) return root

            if (root == null) {
                root = lists[minIdx]
                last = root
            } else {
                last!!.next = lists[minIdx]
                last = last.next
            }

            lists[minIdx] = lists[minIdx]!!.next
        }
    }

    // O(kn * log(k))
    fun mergeKListsPriorityQueue(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        val pq = PriorityQueue<ListNode>(lists.size, compareBy { it.`val` })

        lists.forEach {
            it?.let { pq.add(it) }
        }

        if (pq.isEmpty()) return null

        var root: ListNode? = null
        var last: ListNode? = null
        while (pq.isNotEmpty()) {
            val cur = pq.poll()
            if (root != null) {
                last!!.next = cur
                last = cur
            } else {
                root = cur
                last = cur
            }
            cur.next?.let { pq.offer(it) }
        }

        return root
    }
}

fun main() {

}