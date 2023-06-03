import futures.task_futures_sequence
import module1.{future, list, opt}
import module2.implicits.implicit_scopes

import scala.concurrent.Future
import scala.language.postfixOps

object Main {

  def main(args: Array[String]): Unit = {
    println("Hello world " + Thread.currentThread().getName)

//    val t1 = new Thread{
//      override def run(): Unit = {
//        Thread.sleep(1000)
//        println("Hello world " + Thread.currentThread().getName)
//      }
//    }
//    val t2 = new Thread{
//      override def run(): Unit = {
//        Thread.sleep(2000)
//        println("Hello world " + Thread.currentThread().getName)
//      }
//    }
//    t2.start()
//    t2.join()
//    t1.start()

//    def rates = {
//      val t1 = threads.getRatesLocation3
//      val t2 = threads.getRatesLocation4
//      println(t1 + t2)
//    }

//    implicit val ex: Executor = ???

//    val t3 = ToyFuture(10)
//    val t4 = ToyFuture(20)

//    val r: Unit = t3.onComplete{ i1 =>
//      t4.onComplete{ i2 =>
//        println(i1 + i2)
//      }
//    }
//
//    val r2: ToyFuture[Unit] = for{
//      i1 <- t3
//      i2 <- t4
//    } yield println(i1 + i2)




//    threads.printRunningTime(rates)

//    try_.readFromFile().foreach(println)

//    Try("").map(_.toInt).foreach(println)

    import scala.concurrent.ExecutionContext.Implicits.global


    def rates2: Future[Int] = {
      val v1 = future.getRatesLocation1
      val v2 = future.getRatesLocation2
      for {
        r1 <- v1
        r2 <- v2
      } yield (r1 + r2)
    }


    println("Hello world")

    println("  Module 01 EX 01 ")

    println("=================Option=============")
    opt.printIfAny(opt.Option.Some("some"))
    opt.printIfAny(opt.Option.None)
    println(opt.zip(opt.Option.Some("a"), opt.Option.Some("b")))
    println(opt.filter(opt.Option.Some(5))(x => x < 10)) // 5
    println(opt.filter(opt.Option.Some(5))(x => x > 10)) // None
    println("=================List===============")
    println(list.mkString(list.List(111,222,3333,4444))("<"))
    println(list.::(55)(list.List(66,77,88)))
    println(list.::(55)(list.List.Nil))
    println(list.cons(1,5,6))
    println(s"Reverse - ${list.reverse(list.List(1,2,3,4), list.List.Nil)}")
    println(list.map(list.List(1,2,3,4))(x => x+2))
    println(list.filter(list.List(1,2,3,4))(x => x > 2))
    println(list.incList(list.List(1,2,3,4)))
    println(list.shoutString(list.List("help", "me", "finish", "this", "course")))




    def rates3 =
      future.getRatesLocation1
        .zip(future.getRatesLocation2)

//    future.printRunningTime(rates3)
//      .foreach(println)

//    Await.result(future.f7, 6 seconds)
   // Thread.sleep(4000)

    implicit_scopes.result
    val fu = task_futures_sequence.fullSequence(List(Future(20), Future(throw new RuntimeException("RuntimeException")), Future(12), Future(15), Future(1/0)))
    Thread.sleep(2000)
    println(fu)
  }
}