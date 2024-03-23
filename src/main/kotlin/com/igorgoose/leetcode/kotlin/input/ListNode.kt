package com.igorgoose.leetcode.kotlin.input

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString() = "ListNode(${`val`})"
}

fun IntArray.toListNodes(): ListNode? = fold((null as ListNode?) to (null as ListNode?)) { (root, last), value ->
    val newNode = ListNode(value)
    if (root == null) {
        return@fold newNode to newNode
    }
    last!!.next = newNode
    root to newNode
}.first

fun ListNode?.listAsString(): String {
    return buildString {
        append(this@listAsString?.toString() ?: "null")
        var cur = this@listAsString?.next
        while (cur != null) {
            append("-> $cur")
            cur = cur.next
        }
    }
}