import zio._
import zio.http._
import scala.xml._

object RSSFeedOperations {
  def fetchItemsFromMultipleSources(
      feedUrls: List[String]
  ): ZIO[Client, Throwable, List[String]] = {
    ZIO
      .foreachPar(feedUrls)(feedUrl => // Use ZIO.foreachPar
        for {
          data <- fetchData(feedUrl)
          xml <- stringToXml(data)
          items <- extractItems(xml)
        } yield items
      )
      .map(_.flatten)
  }

  def fetchData(feedUrl: String): ZIO[Client, Throwable, String] =
    ZIO.service[Client].flatMap { client =>
      client
        .batched(Request.get(feedUrl))
        .flatMap { res =>
          res.body.asString
        }
    }

  def stringToXml(xml: String) =
    ZIO.attempt {
      XML.loadString(xml)
    }

  def extractItems(xml: Elem) =
    ZIO.attempt {
      (xml \\ "item" \\ "title").map(_.text).toList
    }
}
