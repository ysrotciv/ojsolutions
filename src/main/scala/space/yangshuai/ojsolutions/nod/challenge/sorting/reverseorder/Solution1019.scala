package space.yangshuai.ojsolutions.nod.challenge.sorting.reverseorder

/**
  * Created on 2017/4/28.
  *
  * @author shuai.yang
  */
object Solution1019 {

  var arr: Array[Int] = _
  var temp: Array[Int] = _
  var count = 0

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readLine().toInt
    arr = new Array[Int](n)
    temp = new Array[Int](n)

    for (i <- 0 until n) {
      arr(i) = scala.io.StdIn.readLine().toInt
    }

    merge(0, n - 1)
    println(count)
  }

  private def merge(low: Int, high: Int): Unit = {

    if (high == low + 1 && arr(high) < arr(low)) {
      swap(low, high)
      count += 1
      return
    } else if (low == high) {
      return
    }
    val mid = (low + high) / 2

    merge(low, mid)
    merge(mid + 1, high)

    var l = low
    var h = mid + 1
    var start = low

    while (l <= mid && h <= high) {
      if (arr(l) > arr(h)) {
        temp(start) = arr(h)
        count += mid - l + 1
        h += 1
      } else {
        temp(start) = arr(l)
        l += 1
      }
      start += 1
    }
    while (l <= mid) {
      temp(start) = arr(l)
      l += 1
      start += 1
    }
    while (h <= high) {
      temp(start) = arr(h)
      h += 1
      start += 1
    }

    for (i <- low to high) {
      arr(i) = temp(i)
    }
  }

  private def swap(low: Int, high: Int): Unit = {
    val temp = arr(low)
    arr(low) = arr(high)
    arr(high) = temp
  }

}
