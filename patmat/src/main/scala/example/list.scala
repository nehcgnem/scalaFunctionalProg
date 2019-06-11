package example

trait List[T] {
  def isEmpty : Boolean
  def head : T
  def tail : List [T]
}

class Cons[T] (val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  override def isEmpty: Boolean = true
  def head : Nothing = throw new NoSuchElementException("Nil.head")
  def tail : Nothing = throw new NoSuchElementException("Nil.head")
}

object List {
  
  //  List() //the empty list
  //  List(1) //the list with single element 1.
  //  List(2, 3) // the list with elements 2 and 3
  //  List(1,2) = List.apply(1,2)
  def apply[T](x1: T, x2: T) : List[T] = new Cons(x1, new Cons(x2, new Nil))
  def apply[T] () = new Nil

}