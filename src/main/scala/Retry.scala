class Retry {
  def retry[A](f: => Either[Exception, A], retryTime: Int, intervalSecond: Int): Either[Exception, A] = {
    println(Console.RED + retryTime + Console.RESET)

    Thread.sleep(intervalSecond * 1000)

    var result: Either[Exception, A] = f

    if(retryTime > 0) {
      if(f.isLeft) result = retry(f, retryTime - 1, intervalSecond)
      else result = retry(f, 0, intervalSecond)
    }

    result
  }

  def retry2[T](fn: => Either[Exception, T], interval: Int, retryTime: Int): Either[Exception, T] = {
    println(Console.GREEN + retryTime + Console.RESET)

    Thread.sleep(interval * 1000)

    if(retryTime > 0 && fn.isLeft) {
      retry2(fn, interval, retryTime-1)
    } else {
      fn
    }
  }
}