package org.mekenzh.leetcode

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max


class TreeNode(var `val`: Int) {

  var left: TreeNode? = null
  var right: TreeNode? = null
  override fun toString(): String {
    return "TreeNode(`val`=$`val`, left=$left, right=$right)"
  }

}

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
  if (root == null) {
    return false
  }
  if (root.left == null && root.right == null) {
    return targetSum == root.`val`
  }
  return hasPathSum(root.left, targetSum - root.`val`)
      || hasPathSum(root.right, targetSum - root.`val`)
}

fun isSymmetric(root: TreeNode?): Boolean {
  return symmetricHelper(root?.left, root?.right)
}

private fun symmetricHelper(left: TreeNode?, right: TreeNode?): Boolean {
  if (left == null || right == null) {
    return left == right
  }

  return left.`val` == right.`val`
      && symmetricHelper(left.left, right.right)
      && symmetricHelper(left.right, right.left)
}

fun maxDepth(root: TreeNode?): Int {
  if (root == null) {
    return 0
  }

  val leftAns = maxDepth(root.left)
  val rightAns = maxDepth(root.right)

  return max(leftAns, rightAns) + 1
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
  val res = mutableListOf<MutableList<Int>>()
  if (root == null) {
    return res
  }
  val nodeStack = LinkedList<TreeNode>()
  nodeStack.add(root)
  while (nodeStack.isNotEmpty()) {
    val level = mutableListOf<Int>()
    for (i in 0 until nodeStack.size) {
      val node = nodeStack.poll()
      if (node.left != null) {
        nodeStack.addLast(node.left)
      }
      if (node.right != null) {
        nodeStack.addLast(node.right)
      }
      level.add(i, node.`val`)
    }
    res.add(level)
  }
  return res
}

fun postorderTraversal(root: TreeNode?): List<Int> {
  val result = ArrayList<Int>()
  postorderHelper(root, result)
  return result
}

private fun postorderHelper(root: TreeNode?, result: MutableList<Int>) {
  if (root != null) {
    if (root.left != null) {
      postorderHelper(root.left, result)
    }
    if (root.right != null) {
      postorderHelper(root.right, result)
    }
    result.add(root.`val`)
  }
}

fun inorderTraversal(root: TreeNode?): List<Int> {
  val res: MutableList<Int> = ArrayList()
  inorderHelper(root, res)
  return res
}

private fun inorderHelper(root: TreeNode?, res: MutableList<Int>) {
  if (root != null) {
    if (root.left != null) {
      inorderHelper(root.left, res)
    }
    res.add(root.`val`)
    if (root.right != null) {
      inorderHelper(root.right, res)
    }
  }
}


fun preorderTraversal(root: TreeNode?): List<Int> {
  if (root == null) {
    return listOf()
  }
  val ints = mutableListOf<Int>()
  val nodeStack = ArrayDeque<TreeNode>()
  nodeStack.addFirst(root)
  while (nodeStack.isNotEmpty()) {
    val node = nodeStack.peek()
    node.`val`.let { ints.add(it) }
    nodeStack.pop()
    if (node?.right != null) {
      nodeStack.push(node.right)
    }
    if (node?.left != null) {
      nodeStack.push(node.left)
    }
  }
  return ints
}