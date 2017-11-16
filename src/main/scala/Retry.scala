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
}