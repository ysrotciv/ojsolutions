package space.yangshuai.nodsolution.tutorial.greedy

import scala.collection.mutable

/**
  * Created by rotciv on 2017/4/16.
  */
object Huffman {

  var result = 0

  def main(args: Array[String]): Unit = {

    val count = scala.io.StdIn.readLine().toInt
    val queue = mutable.PriorityQueue[TreeNode]()(Ordering.by((x: TreeNode) => -x.value))

    var sum = 0

    for (_ <- 0 until count) {
      val value = scala.io.StdIn.readLine().toInt
      sum += value
      queue.enqueue(TreeNode(null, null, value))
    }

    while (queue.size > 1) {
      val left = queue.dequeue()
      val right = queue.dequeue()
      val value = left.value + right.value
      queue.enqueue(TreeNode(left, right, value))
    }
    val root = queue.dequeue()
    total(root)
    println(result)
  }

  def total(root: TreeNode): Unit = {
    if (root.left != null) {
      result += root.value
      total(root.left)
      total(root.right)
    }
  }

}



class TreeNode {
  var left: TreeNode = _
  var right: TreeNode = _
  var value: Int = _
}

object TreeNode {
  def apply(left: TreeNode, right: TreeNode, value: Int): TreeNode = {
    val node = new TreeNode()
    node.left = left
    node.right = right
    node.value = value
    node
  }
}