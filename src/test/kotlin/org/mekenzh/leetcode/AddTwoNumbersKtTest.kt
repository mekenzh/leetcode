package org.mekenzh.leetcode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class AddTwoNumbersKtTest {
  private val l1 = ListNode(2)
  private val l2 = ListNode(9)

  @Test
  @DisplayName("Two null inputs")
  fun twoNullLists() {
    assertEquals(ListNode(0), addTwoNumbers(null, null))
  }

  @Test
  fun secondListNull() {
    assertEquals(l1, addTwoNumbers(l1, null))
  }

  @Test
  fun firstListNull() {
    assertEquals(l2, addTwoNumbers(null, l2))
  }

  @Test
  fun oneSizedLists() {
    val expected = ListNode(0)
    expected.next = ListNode(1)
    expected.`val` = 1
    assertEquals(expected, addTwoNumbers(l1, l2))
  }

  @Test
  fun bigListsDifferentSize() {
    val list1 = ListNode(mutableListOf(9,9,9,9,9,9,9))
    val list2 = ListNode(mutableListOf(9,9,9,9))
    val expected = ListNode(mutableListOf(8,9,9,9,0,0,0,1))
    assertEquals(expected, addTwoNumbers(list1, list2))
  }

}