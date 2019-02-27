import scala.annotation.tailrec

object Hamming {
  def distance(str1: String, str2: String): Option[Int] = {
    if (str1.length != str2.length) None
    else Some(getDistance(str1.toVector, str2.toVector, 0))
  }

  @tailrec
  private def getDistance(str1: Vector[Char], str2: Vector[Char], dis: Int): Int = {
    if (str1.isEmpty) dis
    else {
      val acc = if (str1.head != str2.head) 1 else 0
      getDistance(str1.tail, str2.tail, dis + acc)
    }
  }
}