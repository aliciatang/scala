def quickSort(x: Seq[Int]): Seq[Int] = {
  require(x!=null)
  x match {
    case Nil => x
    case head :: tail => {
      val (less, bigger) = tail.partition(_ < head)
      (quickSort(less) :+ head) ++ quickSort(bigger)
    }
  }
}
// Test cases:
println(quickSort(List()).mkString(","))
println(quickSort(List(1, 3, 8, 9, 10, 2)).mkString(","))
