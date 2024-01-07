import zio._

object Init extends ZIOAppDefault{
  case class  Cake(deco: Option[String], base: Option[String])
  override def run =
    for {
      _ <- zio.Console.printLine("start")
      cake = Cake(Some("strawberry"), Some("plain"))
      deco = cake.deco.filter(x => x.contains("strawberry")).map(y => y.concat("_\uD83C\uDF53"))
      _ <- zio.Console.printLine(deco)

      a = cake.base.map(x => x.->("a"))

      _ <- zio.Console.printLine(a)

    }
    yield()
}
