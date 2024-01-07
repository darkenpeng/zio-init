import zio._

object Init extends ZIOAppDefault{
  type Deco = Option[String]
  type Base = Option[String]
  case class  Cake(deco: Deco, base: Base)
  override def run =
    for {
      _ <- zio.Console.printLine("_start")

      deco = Some("strawberry")
      base = Some("plain")
      cake = Cake(deco, base)

      kirby = cake.deco.map(x => x.concat("\uD83C\uDF53"))
      _ <- zio.Console.printLine(kirby)

    }
    yield()
}
