
// week 3, currying
// function returns another function
// sum returns sumF
def sum(f: Int => Int):(Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a>b) 0
    else sumF(a+1,b) +f(a)
  sumF
  }

def sum2(f: Int => Int )(a: Int, b: Int) : Int = {
  if (a>b) 0 else f(a) + sum2(f)(a+1,b)
}

def sumInt(a:Int, b:Int)= sum2(x=>x)(a,b)
sumInt(3,4)

def sumCube = sum(x=> x*x*x)
sumCube(3,4)

//Cube = ???
//sum(Cube)(3,4)
sum(x=>x*x*x)(3,4)
//def Fact (x: Int ):Int = if (x==0) 1 else fact(x-1)
//
//
////sum(???cube)(1,10)
//
//
//def sum (f:Int => Int) (a:Int, b:Int):Int =
//  if (a>b) 0 else f(a) + sum(f) (a+1,b)
//
//
//def sumInts = sum(x => x)
//def sumCubes = sum(x=> x*x*x)
//def sumFact = sum(Fact)
//

def product (f: Int => Int) (a: Int, b:Int) : Int =
  if (a > b) 1
  else f(a) * product (f)(a+1, b)
//  product(x=>x * x) (3,4)

def factorial (n : Int ) = product(x => x)(1, n)

factorial(5)
product(x=>x)(1,5)


def mapReduce (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a:Int, b:Int) : Int =
  if (a>b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a+1,b))


def product2 (a:Int,b:Int): Int  = mapReduce(x=>x, (x,y) => x*y , 1)(a,b)
def sum3 (f:Int => Int ) (a:Int, b:Int) : Int = mapReduce(f, (x,y) => x+y, zero =0)(a,b)

product2 (1,5)
sum3(x=>x)(4,6)
