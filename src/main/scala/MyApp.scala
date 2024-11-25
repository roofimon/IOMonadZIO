import zio._
import zio.http._
import scala.xml._

object RssFeedProcessor extends ZIOAppDefault {

  import RSSFeedOperations._
  import FileOperations._

  val program = for {
    data <- fetchData
    xml <- stringToXml(data)
    items <- extractItems(xml)
    filteredItems <- filterLinesWithKeyword(items, "ukraine")
    _ <- writeFile("sync.txt", filteredItems)
    _ <- Console.printLine(filteredItems.mkString("\n"))
  } yield ()

  override val run = program.provide(Client.default)
}
