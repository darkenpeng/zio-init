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

      kirby = cake.deco.map(x => x.replace("strawberry", "\uD83C\uDF53"))
      _ <- zio.Console.printLine(kirby) //Some(🍓)
      _ <- zio.Console.printLine(cake) // Cake(Some(strawberry),Some(plain)) map이 새로운 케이크를 만들어서 딸기 이모지로 replace함

    }
    yield()
}
