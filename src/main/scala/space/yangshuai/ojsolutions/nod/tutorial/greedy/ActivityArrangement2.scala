package space.yangshuai.ojsolutions.nod.tutorial.greedy

/**
  * Created by rotciv on 2017/3/18.
  */
object ActivityArrangement2 {

  def main(args: Array[String]): Unit = {
    val count = scala.io.StdIn.readLine().toInt

    val map = new collection.mutable.HashMap[Int, Int]

    for (_ <- 0 until count) {
      val arr = scala.io.StdIn.readLine().split(" ")
      map.put(arr(0).toInt, map.getOrElse(arr(0).toInt, 0) + 1)
      map.put(arr(1).toInt, map.getOrElse(arr(1).toInt, 0) - 1)
    }

    val set = map.keySet.toList.sorted

    var max = 0
    var current = 0

    for (key <- set) {
      current += map(key)
      if (max < current) max = current
    }

    println(max)
  }

}
