

def removeAt[T](n: Int, xs: List[T]) =  (xs take n) :::(xs drop n+1)

removeAt(1, List('a', 'b', 'c', 'd')) // List(a, c, d)


def squareList(xs: List[Int]): List[Int] =
  xs map (x=>x^2)

val nums = List(2,-4,5,13,9)
squareList(nums)

val fruits = List("apple", "pineapple", "orange", "banana")

nums filter(x => x>0)
nums filterNot(x => x>0)
nums partition(x => x>0) //return filer::filterNot

nums takeWhile(x => x>0)
nums dropWhile(x => x>0)
nums span(x => x>0)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x0 :: xs1 =>
    val (first, rest) = xs span (x => x ==x0)
    first::pack(rest)
}

pack(List("a", "a", "a", "b", "c", "c", "a"))

def encode[T] (xs: List[T]): List[(T, Int)] = {
  val x = pack(xs)
  x map (y => (y.head, y.length))
}

encode(List("a", "a", "a", "b", "c", "c", "a"))

def concat[T](xs: List[T], ys: List[T]): List[T] =
  (xs foldRight ys) (_ :: _)

//foldLeft = (((ys :: x1) :: x2) :: x3)
//x1.::ys
//x1 is not a list doesn't have :: defined