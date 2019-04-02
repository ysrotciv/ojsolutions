package space.yangshuai.ojsolutions.nod.challenge.greedy

import scala.collection.mutable

/**
  * Created by rotciv on 2017/4/29.
  */
object Solution1255B {

  def main(args: Array[String]): Unit = {
    val arr = scala.io.StdIn.readLine().toCharArray
    val map = mutable.HashMap[Char, Int]()
    for (c <- arr) {
      val value = map.getOrElse(c, 0)
      map.put(c, value + 1)
    }

    val stack = new mutable.Stack[Char]()
    for (c <- arr) {
      while (!stack.contains(c) && stack.nonEmpty && stack.top > c && map(stack.top) > 0) {
        stack.pop()
      }
      if (!stack.contains(c) && (stack.isEmpty || c != stack.top)) {
        stack.push(c)
      }
      map.put(c, map(c) - 1)
    }

    println(new String(stack.toArray.reverse))
  }
}
