package space.yangshuai.ojsolutions.nod.challenge.gametheory

/**
  * Created by rotciv on 2017/5/1.
  */
object Solution1066 {

  def main(args: Array[String]): Unit = {
    val k = scala.io.StdIn.readLine().toInt
    for (_ <- 0 until k) {
      val arr = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      val n = arr(0)
      val k = arr(1)
      if (n % (k + 1) == 0) {
        println("B")
      } else {
        println("A")
      }
    }
  }

}
