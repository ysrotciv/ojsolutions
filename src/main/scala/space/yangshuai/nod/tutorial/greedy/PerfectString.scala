package space.yangshuai.nod.tutorial.greedy

import java.util

/**
  * Created by rotciv on 2017/3/17.
  */
object PerfectString {

  def main(args: Array[String]): Unit = {
    val arr = scala.io.StdIn.readLine().toLowerCase().toCharArray
    val count = new Array[Int](26)

    for (c <- arr) count(c - 'a') += 1
    util.Arrays.sort(count)
    var sum = 0
    for (i <- 0 until 26) {
      sum += count(i) * (i + 1)
    }
    println(sum)

  }

}
