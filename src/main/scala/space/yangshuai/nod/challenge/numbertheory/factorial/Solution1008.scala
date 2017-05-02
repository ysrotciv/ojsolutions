package space.yangshuai.nod.challenge.numbertheory.factorial

/**
  * Created on 2017/4/28.
  *
  * @author shuai.yang
  */
object Solution1008 {

  def main(args: Array[String]): Unit = {
    val arr = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    println((2 to arr(0)).map(_.toLong).toArray.fold(1l)((a: Long, b: Long) => a * b % arr(1)))
  }
}
