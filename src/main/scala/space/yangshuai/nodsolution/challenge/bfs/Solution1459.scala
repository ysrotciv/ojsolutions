package space.yangshuai.nodsolution.challenge.bfs

/**
  * Created by rotciv on 2017/3/3.
  */
object Solution1459 {

  def main(args: Array[String]): Unit = {

    val iterator = scala.io.Source.stdin.getLines()

    val info = iterator.next().split(" ")
    val n = info(0)
    val m = info(1)
    val start = info(2)
    val end = info(3)

    val socres = iterator.next().split(" ")

    val map = scala.collection.mutable.HashMap[Int, String]()

    while (iterator.hasNext) {
      val path = iterator.next()
      map.put(path(0).toInt, s"${path(1)},${path(2)}")
      map.put(path(1).toInt, s"${path(0)},${path(2)}")
    }

    val set = scala.collection.mutable.HashSet[Int]()

  }

}
