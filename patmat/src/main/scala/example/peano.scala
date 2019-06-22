package example

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor = new Succ(this)
  def +(that: Nat): Nat
  def -(that: Nat): Nat
}

object Zero extends Nat {
  def isZero = true
  def predecessor = throw new Error("Zero predecessor")
  def +(that: Nat) = that
  def -(that: Nat) =
    if (that.isZero) this
    else throw new Error("Nat can't less than zero")
}


class Succ(n: Nat) extends Nat {
  override def isZero: Boolean = false
  override def predecessor: Nat = n
  def +(that:Nat) = new Succ(n+that) // new because the number wasn't exist before
  //new Succ( new Succ ( new Succ (i) )))

  def -(that:Nat) =
    if (that.isZero) this
    else n .- (that.predecessor) // the number was defined earlier
}
