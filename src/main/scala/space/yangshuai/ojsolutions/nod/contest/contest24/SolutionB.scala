package space.yangshuai.ojsolutions.nod.contest.contest24

import scala.collection.mutable


/**
  * Created by rotciv on 2017/4/28.
  */
object SolutionB {

  var arr: Array[Int] = _
  var temp: Array[Int] = _
  var count = 0

  def main(args: Array[String]): Unit = {
    val raw = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val n = raw(0)
    val m = raw(1)

    val map = mutable.HashMap[Int, mutable.ListBuffer[Int]]()

    arr = Array.fill[Int](n)(-1)
    temp = new Array[Int](n)

    val values = new Array[Int](m)

    var lastIndex = -1
    for (i <- 0 until m) {
      val value = scala.io.StdIn.readLine().toInt - 1
      if (value != lastIndex) {
        val list = map.getOrElse(value, mutable.ListBuffer[Int]())
        list.append(i)
        map.put(value, list)
      }
      lastIndex = value
    }

    arr(0) = map(0).last
    arr(n - 1) = map(n - 1).head

    for (i <- 0 until m) {
      val value = values(i)
      if (arr(value) == -1) {
        arr(value) = i
      } else {
        replace(arr, value, i)
      }
    }

    merge(0, n - 1)
    println(count)

  }

  private def replace(arr: Array[Int], index: Int, value: Int): Boolean = {
    var equals = false
    var originCount = 0
    var newCount = 0

    for (i <- 0 until index) {
      if (arr(i) != -1 && arr(i) > arr(index)) {
        originCount += 1
      }
      if (arr(i) != -1 && arr(i) > value) {
        newCount += 1
      }
    }

    for (i <- index + 1 until arr.length) {
      if (arr(i) != -1 && arr(i) < arr(index)) {
        originCount += 1
      }
      if (arr(i) != -1 && arr(i) < value) {
        newCount += 1
      }
    }

    if (newCount > originCount) {
      arr(index) = value
    }

    if (newCount == originCount) {
      equals = true
    }
    equals
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
