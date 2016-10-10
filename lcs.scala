// recursion only
def lcs(x: String, y: String) : String= {
  (x, y)  match {
    case ("", "") | ("", _) | (_, "") => ""
    case (x, y) if x(0) == y(0) => x(0) + lcs(x.substring(1), y.substring(1))
    case (x, y) => {
      val csx = lcs(x.substring(1), y)
      val csy = lcs(x, y.substring(1))
      if(csx.length >= csy.length) csx
      else csy
    }
  }
}
def getLongerString(x: String, y: String): String = {
    if(x.length > y.length) x
      else y
}

def lcsDP(x: String, y: String): String = {
  var prev = Array.fill(x.length + 1)("")
  for(iy <- 0 until y.length) {
    var next = scala.collection.mutable.ArrayBuffer.fill(1)("")
    for(ix <- 0 until x.length) {
      val cur = if(x(ix) == y(iy)) {
        prev(ix) + x(ix)
      } else {
        getLongerString(prev(ix+1), next(ix))
      }
      next += cur
    }
    prev = next.toArray
  }
  prev.last
}
println(lcsDP("abcdcg", "abfdc"))
