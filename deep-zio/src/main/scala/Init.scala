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

      kirby = Universe.Kirby("-")

      deco = Some("strawberry")
      base = Some("plain")

      // ~커비가 딸기를 케이크 위에 올린다~

      cake = Cake(deco, None)

//      changedKirby = cake.deco match {
//        // 만약 준비된 데코가 딸기 데코면 커비가 행복해한다
//        case Some(d) if d.equals("strawberry") => kirby.changeStatus(cake)
//        // 데코가 준비되어 있지 않으면 커비가 실망한다
//        case None => kirby.changeStatus(cake)
//      }

      changedKirby = cake.deco.map {
        d => if(d.equals("strawberry")) {
          kirby.changeStatus(cake)
        }
      }

      _ <- zio.Console.printLine(kirby)
      _ <- zio.Console.printLine(changedKirby)

    }
    yield()
}
