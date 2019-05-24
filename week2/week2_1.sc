
// week 2, higher order functions

def sum(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a>b) acc
    else loop(a+1, f(a)+acc)
  }
  loop(a, 0)
}

sum( x=> x*x, 3,5)


def sumInts(a:Int, b:Int) = sum (x => x, a,b)
def sumCube(a:Int, b:Int)  = sum(x=>x*x*x, a, b)
//def sum(f: Int=> Int, a:Int, b:Int): Int =
//  if (a>b) 0
//  else f(a)+sum (f,a+1,b)

def sumFactorial (a:Int, b:Int) = sum(fact, a, b )
def fact (x: Int ):Int = if (x==0) 1 else fact(x-1)


// week 3, currying