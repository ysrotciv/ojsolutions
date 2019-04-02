package space.yangshuai.ojsolutions.nod.challenge.greedy

import java.util.{Comparator, PriorityQueue}

/**
  * Created by rotciv on 2017/4/29.
  */
object Solution1380 {

  var l: Array[Int] = _
  var r: Array[Int] = _
  var m: Array[Int] = _

  def main(args: Array[String]): Unit = {

    val n = scala.io.StdIn.readLine().toInt
    val queue = new PriorityQueue[(Int, Int)](n, new Comparator[(Int, Int)]() {
      override def compare(o1: (Int, Int), o2: (Int, Int)): Int = o2._2 - o1._2
    })

    l = new Array[Int](n)
    r = new Array[Int](n)
    m = new Array[Int](n)

    for (i <- 0 until n) {
      val value = scala.io.StdIn.readLine().toInt
      m(i) = value
      queue.add((i, value))
      l((i + 1) % n) = i
      r(i) = (i + 1) % n
    }

    var ans = 0l

    for (_ <- 0 until n / 3) {

      val pair = queue.poll()
      val max = pair._2
      val maxIndex = pair._1

      ans += max
      val preIndex = l(maxIndex)
      val pre = m(preIndex)
      val nextIndex = r(maxIndex)
      val next = m(nextIndex)

      val newValue = pre + next - max
      queue.remove((preIndex, pre))
      l(maxIndex) = l(preIndex)
      r(l(preIndex)) = maxIndex
      queue.remove((nextIndex, next))
      r(maxIndex) = r(nextIndex)
      l(r(nextIndex)) = maxIndex
      m(maxIndex) = newValue
      queue.add(maxIndex, newValue)
    }

    println(ans)
  }

}
