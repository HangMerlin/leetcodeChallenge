package Challenge052020

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/
 * Cousins in Binary Tree
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 *
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 *
 *
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 * Note:
 *
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 *
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
class Question07 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  object Solution {
    def isCousins(root: TreeNode, x: Int, y: Int): Boolean = {
      var parentX: Option[TreeNode] = None
      var parentY: Option[TreeNode] = None
      var nodes = Seq(root)
      while (parentX.isEmpty && parentY.isEmpty) {
        parentX = nodes.find(n => isParent(n, x))
        parentY = nodes.find(n => isParent(n, y))
        if (parentX.isEmpty && parentY.isEmpty)
          nodes = nodes.flatMap(node => Seq(node.left, node.right).filter(t => t != null))
      }
      (parentX, parentY) match {
        case (Some(p1), Some(p2)) if p1 != p2 => true
        case _                                => false
      }
    }

    def isParent(node: TreeNode, value: Int): Boolean = {
      (node.left != null && node.left.value == value) || (node.right != null && node.right.value == value)
    }
  }

}

