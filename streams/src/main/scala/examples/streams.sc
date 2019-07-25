
def isPrime(i: Int): Boolean = {
  if (i <= 1)
    false
  else if (i == 2)
    true
  else
    !(2 to (i - 1)).exists(x => i % x == 0)
}

((1000 to 10000) filter isPrime) (0)
//res0: Int = 1009

def streamRange(lo: Int, hi: Int): Stream[Int] = {
  print(lo + " ")
  if (lo >= hi) Stream.empty
  //    else Stream.cons (lo, streamRange(lo+1, hi))
  else lo#:: streamRange(lo+1, hi)
}


streamRange(1,10)(3)
//1 2 3 4 res1: Int = 4
streamRange(1,10).take(3).toList
//1 2 3 res2: List[Int] = List(1, 2, 3)

// LAZY EVALUATION
def expr = {
  val x = {print("x"); 1}
  lazy val y = {print("y"); 2}
  def z = {print("y"); 2}

  z + y + x + z + y + x
}

expr

//seeing it in action

streamRange(1000,10000).filter(isPrime).apply (0)
// apply is to get the second prime number
//def apply (n: Int): Int =
//  if (n==0) head
//else tail.apply(n-1)