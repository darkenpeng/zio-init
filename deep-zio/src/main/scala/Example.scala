import org.jsoup.Jsoup
import sttp.client3.*
import zio.*

object Example extends ZIOAppDefault {

  def getSomething = {
    val client = SimpleHttpClient()

    val response: Response[Either[String, String]] =
      client.send(basicRequest.get(uri"https://www.melon.com/chart/index.htm"))

    response.body match {
      case Left(cause) => ZIO.fail(new Throwable(s"${cause}"))
      case Right(body) => ZIO.succeed(body).debug("succeed result")
    }

  }
  def run: ZIO[Any, Throwable, String] = getSomething

}
