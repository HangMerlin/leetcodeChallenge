package Challenge052020

/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3339/
 *
 * Construct Binary Search Tree from Preorder Traversal
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node,
 * any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
 * Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 *
 * It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
 */

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

//DFS solution
object Solution {
  def bstFromPreorder(preorder: Array[Int]): TreeNode = {
    var parentList = scala.collection.mutable.Seq.empty[TreeNode]
    val root = new TreeNode(preorder(0))

    def bstFromPreorderWithIndex(index: Int, parent: TreeNode): Unit = {
      if (index != preorder.length) {
        if (parent.value > preorder(index)) {
          parent.left = new TreeNode(preorder(index))
          parentList = parentList.+:(parent)
          bstFromPreorderWithIndex(index + 1, parent.left)
        } else {
          if (parentList.isEmpty || preorder(index) < parentList.head.value) {
            parent.right = new TreeNode(preorder(index))
            bstFromPreorderWithIndex(index + 1, parent.right)
          } else {
            val newParent = parentList.head
            parentList = parentList.tail
            bstFromPreorderWithIndex(index, newParent)
          }
        }
      }
    }

    bstFromPreorderWithIndex(1, root)
    root
  }
}

//recursive (not tailRec) solution
object Solution2 {
  def bstFromPreorder(preorder: Array[Int]): TreeNode =
    bstFromPreorderWithRange(0, preorder.length - 1, preorder)

  def bstFromPreorderWithRange(start: Int, end: Int, preorder: Array[Int]): TreeNode = {
    if (start > end) null
    else {
      val node = new TreeNode(preorder(start))
      val leftIndexBound = (start to end).find(i => preorder(i) > preorder(start)).getOrElse(end + 1) - 1
      node.left = bstFromPreorderWithRange(start + 1, leftIndexBound, preorder)
      node.right = bstFromPreorderWithRange(leftIndexBound + 1, end, preorder)
      node
    }
  }
}