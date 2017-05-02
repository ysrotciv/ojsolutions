package space.yangshuai.nod.tutorial.dp

import scala.collection.mutable

/**
  * Created by rotciv on 2017/4/22.
  */
object MultiBag {

  def main(args: Array[String]): Unit = {

    val temp = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val n = temp(0)
    val w = temp(1)

    var typeVols = new Array[Int](n)
    var typePrices = new Array[Int](n)
    var typeNums = new Array[Int](n)

    for (i <- 0 until n) {
      val arr = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      typeVols(i) = arr(0)
      typePrices(i) = arr(1)
      typeNums(i) = arr(2)
    }

    val (vols, prices) = convert(typeNums, typeVols, typePrices)

    val sum = vols.length


    val matrix = Array.ofDim[Int](sum + 1, w + 1)

    for (i <- 0 to sum) {
      for (j <- 0 to w) {
        if (i == 0 || j == 0) {
          matrix(i)(j) = 0
        } else {
          if (j < vols(i - 1)) {
            matrix(i)(j) = matrix(i - 1)(j)
          } else {
            matrix(i)(j) = max(matrix(i - 1)(j - vols(i - 1)) + prices(i - 1), matrix(i - 1)(j))
          }
        }
      }
    }

    println(matrix(sum)(w))
  }

  def max(a: Int, b: Int): Int = {
    if (a > b) {
      a
    } else {
      b
    }
  }

  def convert(nums: Array[Int], vols: Array[Int], prices: Array[Int]): (Array[Int], Array[Int]) = {

    val volList = mutable.ListBuffer[Int]()
    val priceList = mutable.ListBuffer[Int]()

    for (i <- nums.indices) {
      var num = nums(i)
      var count = 1
      while (num >= count) {
        volList.append(vols(i) * count)
        priceList.append(prices(i) * count)
        num -= count
        count *= 2
      }
      if (num > 0) {
        volList.append(vols(i) * num)
        priceList.append(prices(i) * num)
      }
    }

    (volList.toArray, priceList.toArray)
  }

}
