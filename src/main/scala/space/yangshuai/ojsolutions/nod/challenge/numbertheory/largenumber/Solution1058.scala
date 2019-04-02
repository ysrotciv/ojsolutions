package space.yangshuai.ojsolutions.nod.challenge.numbertheory.largenumber

/**
  * Created by rotciv on 2017/5/1.
  */
object Solution1058 {

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readLine().toInt
    val arr = (1 to n).map(math.log10(_))
    println(math.ceil(arr.sum).toInt)
  }

}
