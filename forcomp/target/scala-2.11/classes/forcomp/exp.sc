
List("Every", "student", "likes", "Scala").groupBy(_.length)

List("Every", "student", "likes", "Scala").groupBy(element=> element.length)

List("Every", "student", "likes", "Scala").groupBy((element: String) => element.length).toList



//"every".groupBy(element=> element.length)
"test".toLowerCase().groupBy(x=>x).mapValues(x=>x.length).toList.sorted



val strList = List("test", "good")
strList.mkString("")


//val listPair = List(('a', 2), ('b', 2))
//listPair.toSet.subsets.map(_.toList).toList

val abba = List(('a', 2), ('b', 2))
val abbacomb = List(
  List(),
  List(('a', 1)),
  List(('a', 2)),
  List(('b', 1)),
  List(('a', 1), ('b', 1)),
  List(('a', 2), ('b', 1)),
  List(('b', 2)),
  List(('a', 1), ('b', 2)),
  List(('a', 2), ('b', 2))
)

abba.toSet.subsets.map(_.toList).toList
abbacomb.toSet.subsets.map(_.toList).toList





val x = List(('e', 2), ('a', 3), ('t', 1))

val y = List(('a', 1), ('e', 1))

var(a,b)=x.partition(x => y.exists(y => x._1 == y._1))
a= a.sorted

for( (a,b) <- a.sorted.zip(y))yield (a._1,a._2-b._2)
a.zip(y)

//(List((a,1), (e,1)),List((t,1)))