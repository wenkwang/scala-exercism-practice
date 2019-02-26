object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    val list = List.range(1, limit)
    list.filter(num => factors.exists(n => num % n == 0)).sum
  }
}

