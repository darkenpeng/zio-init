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

      a = cake.deco match {
        // 만약 데코가 준비되어 있으면 딸기 이모지로 바꿔준다
        case Some(d) => d.replace("strawberry", "\uD83C\uDF53")
        // 데코가 준비되어 있지 않으면 커비가 실망한다
        case None => kirby.changeStatus(cake)// Field defined in DelayedInit is likely to be null -> Init 실행할 때 Universe 안의 커비가 인스턴스화 되지 않으면 커비는 null임
      }

      _ <- zio.Console.printLine(a)
      _ <- zio.Console.printLine(cake)

    }
    yield()
}
