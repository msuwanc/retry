object Main extends App {
  val retry: Retry = new Retry
  
  val either: Either[Exception, Int] = Left(new Exception("Failed"))
  val either2: Either[Exception, Int] = Right(1)

  val result: Either[Exception, Int] = retry.retry(either2, 3, 10)
  
  println(Console.GREEN + result + Console.RESET)
}