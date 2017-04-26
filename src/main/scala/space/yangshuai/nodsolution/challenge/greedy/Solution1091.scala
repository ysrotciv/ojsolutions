package space.yangshuai.nodsolution.challenge.greedy

/**
  * Created by rotciv on 2017/4/25.
  */
object Solution1091 {

  def main(args: Array[String]): Unit = {

    val n = scala.io.StdIn.readLine().toInt
    var lines = new Array[Line](n)
    var max = 0

    for (i <- 0 until n) {
      val arr = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      val newLine = Line(arr(0), arr(1))
      lines(i) = newLine
    }

    lines = lines.sortWith(compare)

    for (i <- 1 until n) {
      var index = i - 1
      while (index >= 0 && lines(i).start < lines(index).end) {
        val value = diff(lines(i), lines(index))
        if (value > max) {
          max = value
        }
        index -= 1
      }
    }

    println(max)
  }

  private def compare(a: Line, b: Line): Boolean = {
    if (a.start > b.start) {
      true
    } else if (a.start < b.start) {
      false
    } else if (a.end > b.end) {
      true
    } else {
      false
    }
  }

  private def diff(a: Line, b: Line): Int = {

    var low = a
    var high = b

    if (a.start > b.start) {
      low = b
      high = a
    }

    if (high.start >= low.end) {
      0
    } else {
      min(low.end - high.start, high.end - high.start)
    }
  }

  def min(a: Int, b: Int): Int = {
    if (a < b) {
      a
    } else {
      b
    }
  }

  case class Line(start: Int, end: Int)

}
