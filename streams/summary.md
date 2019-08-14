# Functional Program Design in Scala

## Lecture 2.4 - Computing with Infinite Sequences

#### Infinite Stream

Stream of all integers starting from a given number:

```scala
def from (n: Int): Stream[Int] = n#::from(n+1)
```

The stream of all natural numbers: 

```scala
val nats = from(0)
```

The stream of all multiples of 4:

```scala
nats map(_ * 4)
```

Similar result can be achieved by, but generates the results slower. 

```scala
nats filter (_ % 4 == 0) 
```



#### The Sieve of Eratosthenes 

The Sieve of Eratosthenes is an ancient techniques to calculate prime numbers.

* start with all integers from 2
* Eliminate all multiples of 2
* The first elements of the resulting list is 3, a prime number.
* Eliminate all multiples of 3
* Iterate forever. At each step, the first number in the list is a prime number and we eliminate all its multiples

```scala
def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0))
```

```scala
sieve(from(2)).take(100).toList
> res1: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541)
```



#### Square root 

With stream the square root approximation can be expressed without a termination condition.

```scala
def sqrtStream(x: Double): Stream[Double] = {
  def improve(guess: Double) = (guess + x / guess) / 2

  lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
  guesses
}

def isGoodEnough(guess: Double, x: Double) =
  math.abs((guess * guess - x) / x) < 0.0001
```

```scala
sqrtStream(4).take(20).toList
> res0: List[Double] = List(1.0, 2.5, 2.05, 2.000609756097561, 2.0000000929222947, 2.000000000000002, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0)

sqrtStream(4).filter(isGoodEnough(_,4)).take(10).toList
>res1: List[Double] = List(2.0000000929222947, 2.000000000000002, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0)
```

## Lecture 2.5 - Case Study: the Water Pouring Problem

Given two cups with different capacity, generate paths to reach the target volume. 

```scala
package examples

class Pouring(capacity: Vector[Int]) {
  //States

  type State = Vector[Int]
  val initialState = capacity map (x => 0)

  //Moves
  trait Move

  case class Empty(glass: Int) extends Move

  case class Fill(glass: Int) extends Move

  case class Pour(from: Int, to: Int) extends Move

  val glasses = 0 until capacity.length

  val moves =
      (for (g <- glasses) yield Empty(g)) ++
      (for (g <- glasses) yield Fill(g)) ++
      (for (from <- glasses; to <- glasses if from != to) yield Pour(from, to))
// concatenation 

}

```

