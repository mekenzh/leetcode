package org.mekenzh.leetcode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TreesKtTest {

  @Test
  fun preorderTraversal() {
    val root = TreeNode(3)
    root.left = TreeNode(1)
    root.right = TreeNode(2)
    assertEquals(listOf(3, 1, 2), preorderTraversal(root))
  }

  @Test
  fun levelOrder() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)
    assertEquals(listOf(listOf(3), listOf(9, 20), listOf(15, 7)), levelOrder(root))
  }

  @Test
  fun maxDepth() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.right = TreeNode(15)
    root.right!!.left = TreeNode(7)
    assertEquals(3, maxDepth(root))
  }

  @Test
  fun isSymmetric() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    assertEquals(true, isSymmetric(root))
    assertEquals(true, isSymmetric(null))
  }

  @Test
  fun hasPathSum() {
    val root = TreeNode(5)
    root.left = TreeNode(4)
    root.left!!.left = TreeNode(11)
    root.left!!.left?.left = TreeNode(7)
    root.left!!.left?.right = TreeNode(2)
    root.right = TreeNode(8)
    root.right!!.left = TreeNode(13)
    root.right!!.right = TreeNode(4)
    root.right!!.right?.right = TreeNode(1)
    assertEquals(true, hasPathSum(root, 22))

    val root1 = TreeNode(1)
    root1.left = TreeNode(-2)
    root1.left!!.left = TreeNode(1)
    root1.left!!.right = TreeNode(3)
    root1.left!!.left?.left = TreeNode(-1)



    root1.right = TreeNode(-3)
    root1.right!!.left = TreeNode(-2)
    root1.right!!.right = null

    assertEquals(false, hasPathSum(root1, 3))
  }
}