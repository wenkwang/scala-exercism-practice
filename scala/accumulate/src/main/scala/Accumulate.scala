import scala.annotation.tailrec

class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] = accumulateHelper(list, List.empty[B], f)

  @tailrec
  private def accumulateHelper[A, B](listA: List[A], listB: List[B], f: (A) => B): List[B] = {
    if (listA.isEmpty) listB.reverse
    else accumulateHelper(listA.tail, f(listA.head) +: listB, f)
  }
}
