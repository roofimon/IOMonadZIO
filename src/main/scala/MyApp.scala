import zio._
import zio.http._
import scala.xml._
import zio.durationInt

object RssFeedProcessor extends ZIOAppDefault {

  val feedUrls = List(
    "http://rss.cnn.com/rss/money_topstories.rss",
    "https://feeds.bbci.co.uk/news/rss.xml"
  )

  import RSSFeedOperations._
  import FileOperations._

  val program: ZIO[Client, Throwable, Unit] = for {
    startTime <- Clock.nanoTime

    items <- fetchItemsFromMultipleSources(feedUrls)
    filteredItems <- filterItemsWithKeyword(items, "is")
    _ <- Console.printLine(filteredItems.mkString("\n"))

    endTime <- Clock.nanoTime
    duration = (endTime - startTime).nanos
    _ <- Console.printLine(s"Execution time: $duration")

    _ <- writeFile("sync.txt", filteredItems)

  } yield ()

  override val run = program.provide(Client.default)
}
