package futures

import scala.concurrent.{ExecutionContext, Future}

object task_futures_sequence {

  /**
   * В данном задании Вам предлагается реализовать функцию fullSequence,
   * похожую на Future.sequence, но в отличии от нее,
   * возвращающую все успешные и не успешные результаты.
   * Возвращаемое тип функции - кортеж из двух списков,
   * в левом хранятся результаты успешных выполнений,
   * в правово результаты неуспешных выполнений.
   * Не допускается использование методов объекта Await и мутабельных переменных var
   */
  /**
   * @param futures список асинхронных задач
   * @return асинхронную задачу с кортежом из двух списков
   */
  def fullSequence[A](futures: List[Future[A]])
                     (implicit ex: ExecutionContext): Future[(List[A], List[Throwable])] = {

    futures.foldRight(Future(List.empty[A], List.empty[Throwable])){ (future, futureTuple) =>
      futureTuple.flatMap { listAlistThrowable =>
        val valList = listAlistThrowable._1
        val throwList = listAlistThrowable._2
        future.map{ a =>
          (a +: valList, throwList)
        }.recover{ exception =>
          (valList, exception +: throwList)
        }
      }
    }
  }
}
