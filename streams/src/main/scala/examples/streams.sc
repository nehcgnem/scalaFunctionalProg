
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