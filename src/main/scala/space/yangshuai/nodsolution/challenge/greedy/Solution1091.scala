package space.yangshuai.nodsolution.challenge.greedy

import scala.collection.mutable

/**
  * Created by rotciv on 2017/4/25.
  */
object Solution1091 {

  def main(args: Array[String]): Unit = {

    val n = scala.io.StdIn.readLine().toInt
    var lines = new Array[Line](n)
    val list = mutable.ListBuffer[Line]()
    var max = 0

    for (i <- 0 until n) {
      val arr = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      val newLine = Line(arr(0), arr(1), arr(1) - arr(0))
      lines(i) = newLine
    }

    lines = lines.sortWith(compare)
    list.append(lines(0))

    var times = 0
    var currentEnd = 0

    for (i <- 1 until n) {
      val currentLine = lines(i)
      if (currentLine.end == currentEnd) {
        times += 1
      } else {
        currentEnd = currentLine.end
        times = 0
      }
      if (times < 2) {
        for (line <- list) {
          val value = diff(line, currentLine)
          if (value > max) {
            max = value
          }
        }
        addList(list, currentLine)
      }
    }

    println(max)
  }

  private def addList(list: mutable.ListBuffer[Line], line: Line): Unit = {
    val newList = list.dropWhile(l => l.end <= line.end && l.length <= line.length)
    if (newList.size < list.size) {
      list.append(line)
    }
  }

  private def compare(a: Line, b: Line): Boolean = {
    if (a.end < b.end) {
      true
    } else if (a.end > b.end) {
      false
    } else if (a.start < b.start) {
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

  case class Line(start: Int, end: Int, length: Int)
}
