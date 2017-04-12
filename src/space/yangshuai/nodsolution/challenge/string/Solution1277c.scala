package space.yangshuai.nodsolution.challenge.string

/**
  * Created by rotciv on 2017/3/3.
  */
object Solution1277c {

  def main(args: Array[String]): Unit = {

    val source = scala.io.Source.stdin.getLines().next().toArray
    var max = source.length
    val prefixLength = prefix(source)
    val count = new Array[Int](max)

    for (value <- prefixLength) {
      if (value > 0) {
        count(value - 1) += 1
      }
    }

    for (i <- 1 until max) {
      if (source(i) == source(0)) {
        if (prefixLength(i + 1) > 1) {
          count(0) += 1
          var j = 1
          while ((i + j + 1) <= max && prefixLength(i + 1 + j) > j + 1) {
            count(j) += 1
            j += 1
          }
        }
      }
    }

    for (i <- count.indices) {
      val multi = (count(i) + 1) * (i + 1)
      if (multi > max) max = multi
    }

    println(max)
  }

  private def prefix(pattern: Array[Char]): Array[Int] = {

    val length = pattern.length
    val prefixFunc = new Array[Int](length + 1)
    prefixFunc(1) = 0
    var k = 0

    for (q <- 2 to length) {
      while( k > 0 && (pattern(k) != pattern(q - 1)))
        k = prefixFunc(k)
      if(pattern(k) == pattern(q - 1))
        k += 1
      prefixFunc(q) = k
    }

    prefixFunc
  }

  def getNext(p: Array[Char]): Array[Int] = {
    val pLen = p.length
    val next = new Array[Int](pLen + 1)
    next(0) = -1
    var k = -1
    var j = 0
    while (j < pLen - 1)
    {
      //p[k]表示前缀，p[j]表示后缀
      if (k == -1 || p(j) == p(k))
      {
        k += 1
        j += 1
        next(j) = k
      }
      else
      {
        k = next(k)
      }
    }

    next
  }

  def getNextVal(p: Array[Char]): Array[Int] = {
    val pLen = p.length
    val next = new Array[Int](pLen + 1)
    next(0) = -1
    var k = -1
    var j = 0
    while (j < pLen - 1) {
      //p[k]表示前缀，p[j]表示后缀
      if (k == -1 || p(j) == p(k))
      {
        j += 1
        k += 1
        //较之前next数组求法，改动在下面4行
        if (p(j) != p(k))
          next(j) = k  //之前只有这一行
        else
        //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
          next(j) = next(k)
      }
      else
      {
        k = next(k)
      }
    }

    next
  }

}
