package org.mekenzh.leetcode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FindKthLargestKtTest {

  @Test
  fun findKthLargestTest() {
    assertEquals(5, findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    assertEquals(4, findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6), 4))
  }
}