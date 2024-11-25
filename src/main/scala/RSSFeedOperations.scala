import zio._
import zio.http._
import scala.xml._

object RSSFeedOperations {
  val feedUrl = "https://feeds.bbci.co.uk/news/rss.xml"

  def fetchData: ZIO[Client, Throwable, String] =
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
