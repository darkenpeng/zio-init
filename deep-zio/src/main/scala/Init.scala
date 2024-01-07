import Init.Cake
import zio._

object Universe extends App {
  case class Kirby(status: String) {
    def changeStatus(cake: Cake) = cake.deco match {
      case Some(d) => Kirby.apply("Happy")
      case None => Kirby.apply("Disappointed")// this.status.replace(this.status, "Disappointed")
    }
  }
}

object Init extends ZIOAppDefault{
  type Deco = Option[String]
  type Base = Option[String]
  case class  Cake(deco: Deco, base: Base)
  override def run =
    for {
      _ <- zio.Console.printLine("_start")

      kirby = Universe.Kirby("Happy")

      deco = Some("strawberry")
      base = Some("plain")

      // ~커비가 딸기를 케이크 위에 올린다~

      // 하지만 아무도 케이크 데코와 베이스를 준비하지 않았다...(빈 케이크)
      cake = Cake(None, None)

      changedKirby = cake.deco match {
        // 만약 데코가 준비되어 있으면 딸기 이모지로 바꿔준다
        case Some(d) => d.replace("strawberry", "\uD83C\uDF53")
        // 데코가 준비되어 있지 않으면 커비가 실망한다
        case None => kirby.changeStatus(cake)
      }

      _ <- zio.Console.printLine(kirby) // 행복한 커비는 그대로 있음
      _ <- zio.Console.printLine(changedKirby) // 실망한 커비는 새롭게 만들어져서 changedKirby에 담김

    }
    yield()
}
