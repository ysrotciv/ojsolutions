package space.yangshuai.nod.challenge.gametheory

import scala.collection.mutable

/**
  * Created by rotciv on 2017/5/1.
  */
object Solution1069 {

  def main(args: Array[String]): Unit = {
    import java.io.BufferedReader
    import java.io.InputStreamReader
    val in = new BufferedReader(new InputStreamReader(System.in))
    val n = in.readLine.toInt
    var result = 0
    var i = 0
    while ( {
      i < n
    }) {
      result ^= in.readLine.toInt

      {
        i += 1; i - 1
      }
    }
    System.out.println(if (result == 0) "B"
    else "A")
  }

}
