object Main extends App {
  val retry: Retry = new Retry
  
  val either: Either[Exception, Int] = Left(new Exception("Failed"))
  val either2: Either[Exception, Int] = Right(1)

  val result: Either[Exception, Int] = retry.retry(either2, 3, 10)
  val result2: Either[Exception, Int] = retry.retry(either, 3, 10)

  println(Console.GREEN + result + Console.RESET)
  println(Console.GREEN + result2 + Console.RESET)

  val result3: Either[Exception, Int] = retry.retry2(either2, 10, 3)
  val result4: Either[Exception, Int] = retry.retry2(either, 10, 3)

  println(Console.BLUE + result3 + Console.RESET)
  println(Console.BLUE + result4 + Console.RESET)
}