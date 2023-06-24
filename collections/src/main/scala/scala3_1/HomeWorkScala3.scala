package scala3_1

// 2 реализуйте паттерн "магнит" из ссылки выше для String, Float, Int
object Completions:

  enum CompletionArg:
    case ShowItIsString(s: String)
    case ShowItIsInt(i: Int)
    case ShowItIsFloat(f: Float)

  object CompletionArg:
    given fromString: Conversion[String, CompletionArg] = ShowItIsString(_)

    given fromInt: Conversion[Int, CompletionArg] = ShowItIsInt(_)

    given fromFloat: Conversion[Float, CompletionArg] = ShowItIsFloat(_)
  end CompletionArg

  import CompletionArg._
  def complete[T](arg: CompletionArg) = arg match
    case ShowItIsString(s) => println(s"This is String $s")
    case ShowItIsInt(i) => println(s"This is Int $i")
    case ShowItIsFloat(f) => println(s"This is Float $f")

end Completions


object HomeWorkScala3:
  import Completions._
  // 1 написать расширение Int чтобы реалтзовать поведение "56" + "3" = 563

  extension(intValue: Int)
    def plusConcat(other: Int) = intValue.toString.concat(other.toString)

  @main def program =
    println(22 plusConcat 34)
    complete("Some string")
    complete(22)
    complete(123.44F)


end HomeWorkScala3

