type Set = Int => Boolean
def contains(s: Set, elem: Int): Boolean = s(elem)

contains([2,1], 2)