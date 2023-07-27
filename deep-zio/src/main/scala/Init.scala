import zio._

object Init extends ZIOAppDefault{
  override def run =
    for {
      _ <- zio.Console.printLine("start")
    }
    yield()
}
