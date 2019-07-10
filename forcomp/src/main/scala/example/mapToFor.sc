val n = 7
// vector of vector
val xss = (1 until n) map (i => (1 until i ) map (j =>(i, j)))

def isPrime(n:Int) :Boolean = (2 until n) forall (d=> n%d != 0)



// single vector
//(xss foldRight Seq[Int]())(_ ++ _)

xss.flatten

// xs flatMap f = (xs map f).flatten
(1 until n) flatMap (i => (1 until i ) map (j =>(i, j))) filter (pair => isPrime(pair._1 + pair._2))


def scalarProduct0 (xs: Vector[Double], ys: Vector[Double]):Double ={
  (xs zip ys).map(xy => xy._1 * xy._2).sum
}

def scalarProduct (xs: List[Double], ys: List[Double]) : Double = {
  (for ((x,y) <- xs zip ys) yield x*y).sum
}
