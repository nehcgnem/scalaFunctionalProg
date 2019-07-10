  val s = "Hello World"
  s flatMap (c => List('.',c))
  s.max

  (1 to 3) flatMap(x=>(4 to 6) map (y =>(x,y)))
  (1 to 3) map(x=>(4 to 6) map (y =>(x,y)))

  def isPrime(n:Int) :Boolean = (2 until n) forall (d=> n%d != 0)
  isPrime(12)
  isPrime(0)

  for {
    i <- 1 until 5
    j <- 1 until i
    if isPrime(i+j)
  } yield (i,j)