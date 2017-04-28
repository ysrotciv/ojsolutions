package space.yangshuai.nodsolution.challenge.greedy

import scala.collection.mutable

/**
  * Created on 2017/4/27.
  *
  * @author shuai.yang
  */
object Solution1255 {

  def main(args: Array[String]): Unit = {

    val arr = scala.io.StdIn.readLine().toCharArray
    val result = new Array[Char](arr.length)
    val map = mutable.HashMap[Char, mutable.ListBuffer[Int]]()

    for (i <- arr.indices) {
      val c = arr(i)
      if (map.contains(c)) {
        val list = map(c)
        list.append(i)
      } else {
        map.put(c, mutable.ListBuffer[Int](i))
      }
    }

    var index = -1
    map.toArray.sortBy(_._1).foreach(x => {
      if (x._2.size == 1) {
        if (x._2.head > index) {
          index = x._2.head
        }
        result(x._2.head) = x._1
      } else {
        update(index, result, x)
      }
    })

    val builder = new StringBuilder()
    for (c <- result) {
      builder.append(c)
    }
    println(builder.toString())
  }

  private def update(index: Int, arr: Array[Char], tuple: (Char, mutable.ListBuffer[Int])): Unit = {
    var currentIndex = index
    val c = tuple._1
    val list = tuple._2
    while (true) {
      val biggers = list.filter(x => x > currentIndex)
      if (biggers.nonEmpty) {
        arr(biggers.head) = c
        return
      } else {
        val newArr = new Array[Char](currentIndex)
        System.arraycopy(arr, 0, newArr, 0, newArr.length)
        var newIndex = -1
        for (i <- newArr.length - 1 to 0 by -1) {
          if (newArr(i) > 0 && newIndex == -1) {
            newIndex = i
          }
        }
        if (newIndex != -1) {
          currentIndex = newIndex
        } else {
          arr(list.last) = c
          return
        }
      }
    }
  }
}
