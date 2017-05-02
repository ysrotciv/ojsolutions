package space.yangshuai.nod.challenge.sorting

/**
  * Created on 2017/4/18.
  *
  * @author shuai.yang
  */
object Solution1018 {

  var arr: Array[Int] = _

  def main(args: Array[String]): Unit = {

    val n = scala.io.StdIn.readLine().toInt
    arr = new Array[Int](n)

    for (i <- 0 until n) {
      arr(i) = scala.io.StdIn.readLine().toInt
    }

    sort(0, n - 1)
    arr.foreach(println)
  }

  private def sort(start: Int, end: Int): Unit = {
    if (start >= end) {
      return
    }
    if (start == end - 1) {
      if (arr(start) > arr(end)) {
        swap(start, end)
      }
      return
    }

    var low = start + 1
    var high = end

    while (low < high) {
      while (arr(low) < arr(start) && low < high) {
        low += 1
      }
      while (arr(start) < arr(high) && high >= low) {
        high -= 1
      }

      if (low < high) {
        swap(low, high)
      } else {
        swap(start, high)
        sort(start, high - 1)
        sort(high + 1, end)
      }
    }
  }

  private def swap(low: Int, high: Int): Unit = {
    val temp = arr(low)
    arr(low) = arr(high)
    arr(high) = temp
  }

}
