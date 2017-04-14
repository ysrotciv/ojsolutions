package space.yangshuai.nodsolution.tutorial.greedy

/**
  * Created by rotciv on 2017/3/18.
  */
object ActivityArrangement {

  case class Segment(start: Int, end: Int)

  def main(args: Array[String]): Unit = {

    val size = scala.io.StdIn.readLine().toInt
    val set = new collection.mutable.HashSet[Segment]
    val removed = new collection.mutable.HashSet[Segment]
    for (_ <- 0 until size) {
      val temp = scala.io.StdIn.readLine().split(" ")
      val segment = Segment(temp(0).toInt, temp(1).toInt)
      set += segment
    }

    var count = 0
    var start = Int.MinValue
    var min: Segment = null
    var begin = true

    while (begin || min != null) {
      min = null
      if (begin) begin = false
      for (segment <- set) {
        if (segment.start < start) {
          println(s"remove $segment")
          removed.add(segment)
        } else {
          if (min == null || segment.end < min.end) min = segment
        }
      }

      set --= removed

      if (min != null) {
        count += 1
        start = min.end
        println(s"choose $min")
        set.remove(min)
      }
    }

    println(count)
  }

}
