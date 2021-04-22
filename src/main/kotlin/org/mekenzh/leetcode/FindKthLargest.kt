package org.mekenzh.leetcode

fun findKthLargest(nums: IntArray, k: Int): Int {
  nums.sort()
  return nums[nums.size - k]
}