abstract class IntSet {
  def contains(x: Int): Boolean

  def incl(x: Int): IntSet

  def union(other: IntSet): IntSet
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl (x), right)
    else if (x > elem) new NonEmpty(elem, left, right incl (x))
    else this

  def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem

  override def toString: String = "{" + left + elem + right + "}"
}

object Empty extends IntSet {
  def contains(x: Int): Boolean = false

  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

  // add new node
  override def toString: String = "."

  def union(other: Int): IntSet = other
}

val t1 = new NonEmpty(3, Empty, Empty)
val t2 = t1 incl 4



