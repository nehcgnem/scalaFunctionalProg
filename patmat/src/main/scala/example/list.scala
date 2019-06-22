package example

trait List[+T] {
  def isEmpty : Boolean
  def head : T
  def tail : List [T]
  def prepend [U >: T] (elem: U) : List[U] = new Cons(elem, this)
}

class Cons[T] (val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object Nil extends List[Nothing] {
  def isEmpty: Boolean = true
  def head : Nothing = throw new NoSuchElementException("Nil.head")
  def tail : Nothing = throw new NoSuchElementException("Nil.head")
}

object List {
  
  //  List() //the empty list
  //  List(1) //the list with single element 1.
  //  List(2, 3) // the list with elements 2 and 3
  //  List(1,2) = List.apply(1,2)
  def apply[T](x1: T, x2: T) : List[T] = new Cons(x1, new Cons(x2,  Nil))
  def apply[T] () = Nil

}
object test {
  val x: List[String] = Nil
  def f(xs: List[NonEmpty], x: Empty) = xs prepend x
}