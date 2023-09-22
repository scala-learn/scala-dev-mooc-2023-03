package scala3_1

object MyMath:

  opaque type Logarithm = Double

  object Logarithm:

    // These are the two ways to lift to the Logarithm type

    def apply(d: Double): Logarithm = math.log(d)

    def safe(d: Double): Option[Logarithm] =
      if d > 0.0 then Some(math.log(d)) else None

  end Logarithm

  // Extension methods define opaque types' public APIs
  extension (x: Logarithm)
    def toDouble: Double = math.exp(x)
    def + (y: Logarithm): Logarithm = Logarithm(math.exp(x) + math.exp(y))
    def * (y: Logarithm): Logarithm = x + y

end MyMath

object Main {
  import MyMath.Logarithm


  @main def run = {
    val l = Logarithm(1.0)
    val l2 = Logarithm(2.0)
    val l3 = Logarithm.safe(0.0)
    val l4 = Logarithm.safe(2.0)

    val l6 = l * l2

    println(l)
    println(l2)
    println(l3) //None
    println(l4) //Some
    println(l6)

    /*val d: Double = l       // error: found: Logarithm, required: Double
    val l5: Logarithm = 1.0 // error: found: Double, required: Logarithm
    l * 2                   // error: found: Int(2), required: Logarithm
    l / l2                  // error: `/` is not a member of Logarithm*/
    val d: Double = l.toDouble
    println(d)
  }
}
