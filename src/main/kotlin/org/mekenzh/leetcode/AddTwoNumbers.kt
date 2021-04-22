package org.mekenzh.leetcode

class ListNode(var `val`: Int) {
  constructor(ints: MutableList<Int>) : this(ints[0]) {
    if (ints.size == 1) {
      return
    }
    ints.removeAt(0)
    next = ListNode(ints)
  }

  var next: ListNode? = null
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as ListNode

    if (`val` != other.`val`) return false
    if (next != other.next) return false

    return true
  }

  override fun hashCode(): Int {
    var result = `val`
    result = 31 * result + (next?.hashCode() ?: 0)
    return result
  }

  override fun toString(): String {
    return "$`val`,$next)"
  }

}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
  val result = ListNode(0)
  when {
    l1 == null && l2 == null -> return result
    l1 == null -> return l2
    l2 == null -> return l1
  }
  summ(l1, l2, result)
  return result
}

fun summ(l1: ListNode?, l2: ListNode?, result: ListNode) {
  val summ = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + result.`val`
  if (summ < 10) {
    result.`val` = summ
  } else {
    result.`val` = summ % 10
    if (result.next != null) {
      result.next!!.`val` += 1
    } else {
      result.next = ListNode(1)
    }
  }

  if (l1?.next == null && l2?.next == null) {
    return
  }
  if (result.next == null) result.next = ListNode(0)
  summ(l1?.next, l2?.next, result.next!!)
}
