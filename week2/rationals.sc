class Rational(x: Int, y: Int) {
  require(y != 0, "denominator can't be zero")

  // second constructor with one parameter
  def this(x: Int) = this(x: Int, 1)

  def numer = x

  def denom = y

  def add(that: Rational) =
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom
    )

  def neg: Rational = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (less(that)) that else this

  override def toString: String = {
    val g = gcd (numer, denom)
    numer/g + "/" + denom/g
    // normalization only on print which is bad
    // prone to overflow
  }

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  //  private val g = gcd(x, y)
  // or set to val only calculated once
  //val numer = x / gcd(x,y)
  //val denom = y / gcd(x,y)
}


var x = new Rational(1, 2)
x.numer
x.denom

val y = new Rational(2, 3)

//val strange = new Rational(1, 0)
x = x.add(y)

x = x.sub(y)

x.max(y)