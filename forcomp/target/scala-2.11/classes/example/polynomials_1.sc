// heavy coding due to partial function
// Partial function may or may not be defined on the entire domain.
class Poly(val terms : Map [Int, Double]) {
  def + (other: Poly) =  new Poly (terms ++ (other.terms map adjust))// "++" superimpose the other to terms
  def adjust(term: (Int, Double)): (Int, Double) = {
    val (exp, coeff) = term
    terms get exp match {
      case  None => exp -> coeff
      case Some(coeff2) => exp -> (coeff + coeff2)
    }

  }
  override def toString =
    (for((exp, coeff)<- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
}

val p1 = new Poly (Map (1-> 2.0, 3 -> 4.0, 5-> 6.2))
val p2 = new Poly (Map (0->3.0, 3-> 7.0))
p1 + p2


