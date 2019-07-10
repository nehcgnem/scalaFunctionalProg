{
  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] = {
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens
    }

    placeQueens(n)
  }

  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val row = queens.length
    val queensWithRow = (row - 1 to 0 by -1) zip queens
    queensWithRow forall {
      case (r, c) => col != c && math.abs(col - c) != row - r
    }
  }

  def show (queens: List[Int]) ={
    val lines =
      for (col <- queens.reverse)
        yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
    "\n" + (lines  mkString "\n")

  }
  (queens(4) take 3 map show) mkString ("\n")
//  queens(4)

//isSafe(3, List())
  for {
//    queens <- Set(List(0), List(1), List(2), List(3))
//    queens <- Set(List(2, 0), List(0, 2), List(3, 1), List(1, 3), List(0, 3), List(3, 0))
//    queens <- Set(List(3, 0, 2), List(0, 3, 1), List(2, 0, 3), List(1, 3, 0))
//    queens <- Set(List(1, 3, 0, 2), List(2, 0, 3, 1))
    col <- 0 until 4
    if isSafe(col, queens)
  } yield col :: queens
}