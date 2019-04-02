package space.yangshuai.ojsolutions.nod.challenge.string

/**
  * Created by rotciv on 2017/3/4.
  */
object Solution1277 {

  def main(args: Array[String]): Unit = {

    val queue = new scala.collection.mutable.Queue[Int]()
    val map = new scala.collection.mutable.HashMap[Int, Int]()

    val source = scala.io.Source.stdin.getLines().next().toArray
    var max = source.length
    val prefixLength = prefix(source, max)

    for (i <- prefixLength.indices) {
      if (i > 0 && prefixLength(i) < prefixLength(i - 1)) {
        queue.enqueue(prefixLength(i - 1))
      }
    }
    if (prefixLength.last > 1) queue.enqueue(prefixLength.last)

    while (queue.nonEmpty) {
      val key = queue.dequeue()
      val value = map.getOrElse(key, 0)
      map.put(key, value + 1)

      var newKey = prefixLength(key)
      while (newKey > 1) {
        val newValue = map.getOrElse(newKey, 0)
        map.put(newKey, newValue + 1)
        newKey = prefixLength(newKey)
      }
    }

    var count = 0
    map.keySet.toList.sortWith(_ > _).foreach(key => {
      val origin = map(key)
      var value = origin
      if (count == 0) {
        count = value + 1
      } else {
        if (value > 1) {
          value = value * count
          count = value
        } else {
          value += count
          count = value
        }
      }

      println(s"$key -> ${value}")
      if ((key * value) > max) max = key * value
    })

    println(max)
  }


  private def prefix(pattern: Array[Char], length: Int): Array[Int] = {

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

}
