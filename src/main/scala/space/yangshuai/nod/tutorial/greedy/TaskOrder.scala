package space.yangshuai.nod.tutorial.greedy

/**
  * Created by rotciv on 2017/3/18.
  */
object TaskOrder {

  def main(args: Array[String]): Unit = {

    val count = scala.io.StdIn.readLine().toInt
    val arr = new Array[(Int, Int)](count)

    for (i <- 0 until count) {
      val values = scala.io.StdIn.readLine().split(" ")
      arr(i) = (values(0).toInt, values(0).toInt - values(1).toInt)
    }

    var min = 0
    var sum = 0

    arr.sortBy(_._2).reverse.foreach(x => {
      sum -= x._1
      if (min > sum) min = sum
      sum += x._2
    })

    println(min * -1)
  }

}
