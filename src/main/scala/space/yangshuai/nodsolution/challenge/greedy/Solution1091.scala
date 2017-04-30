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
      val newLine = Line(arr(0), arr(1), arr(1) - arr(0))
      lines(i) = newLine
    }

    lines = lines.sortWith(compare)

    var pre: Line = null

    for (line <- lines) {
      if (pre != null) {
        var value = line.length
        if (!contains(pre, line)) {
          value = diff(pre, line)
          pre = line
        }
        if (value > max) {
          max = value
        }
      } else {
        pre = line
      }
    }

    println(max)
  }

  private def contains(parent: Line, child: Line): Boolean = {
    child.start >= parent.start && child.end <= parent.end
  }

  private def compare(a: Line, b: Line): Boolean = {
    if (a.start < b.start) {
      true
    } else if (a.start > b.start) {
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
      Math.min(low.end - high.start, high.end - high.start)
    }
  }

  case class Line(start: Int, end: Int, length: Int)
}
