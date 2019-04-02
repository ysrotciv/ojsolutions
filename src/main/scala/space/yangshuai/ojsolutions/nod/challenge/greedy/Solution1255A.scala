package space.yangshuai.ojsolutions.nod.challenge.greedy

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Created on 2017/4/27.
  *
  * @author shuai.yang
  */
object Solution1255A {

  def main(args: Array[String]): Unit = {

    val arr = scala.io.StdIn.readLine().toCharArray
    val matches = mutable.ListBuffer[Char]()
    for (c <- arr.toSet.toArray.sorted) {
      matches.append(c)
    }
    val ans = new Array[Char](arr.length)
    val firstIndex = Array.fill[Int](arr.length, 26)(-1)

    var index = 0
    for (i <- 0 until arr.length) {
      val c = arr(i) - 'a'
      firstIndex(i)(c) = i
      index = i - 1
      while (index >= 0 && firstIndex(index)(c) == -1) {
        firstIndex(index)(c) = firstIndex(i)(c)
        index -= 1
      }
    }

    var tempIndex = 0
    index = 0
    while (matches.nonEmpty) {
      var matchesIndex = 0
      var notDone = true
      while (notDone) {
        val c = matches(matchesIndex)
        tempIndex = firstIndex(index)(c - 'a')
        if (allExists(firstIndex(tempIndex), c - 'a', matches)) {
          index = tempIndex
          ans(index) = c
          index += 1
          notDone = false
          matches.remove(matchesIndex)
        } else {
          matchesIndex += 1
        }
      }
    }

    println(new String(ans.filter(_ > 0)))
  }

  private def allExists(arr: Array[Int], arrIndex: Int, matches: ListBuffer[Char]): Boolean = {
    for (i <- arrIndex + 1 until arr.length) {
      if (matches.contains('a' + i) && arr(i) == -1) {
        return false
      }
    }
    true
  }

}
