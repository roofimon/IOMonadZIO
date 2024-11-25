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

  // val program = for {
  //   startTime <- Clock.nanoTime
  //   dataA <- fetchData(feedUrls.head)
  //   xml <- stringToXml(dataA)
  //   itemsA <- extractItems(xml)

  //   dataB <- fetchData(feedUrls.last)
  //   xml <- stringToXml(dataB)
  //   itemsB <- extractItems(xml)

  //   items = itemsA ++ itemsB
  //   filteredItems <- filterLinesWithKeyword(items, "is")
  //   endTime <- Clock.nanoTime
  //   duration = (endTime - startTime).nanos
  //   _ <- Console.printLine(s"Execution time: $duration")
  //   // _ <- writeFile("sync.txt", filteredItems)
  //   // _ <- Console.printLine(filteredItems.mkString("\n"))
  // } yield ()

  // val program: ZIO[Client, Throwable, Unit] = for {
  //   startTime <- Clock.nanoTime
  //   fiberA <- (for {
  //     data <- fetchData(feedUrls.head)
  //     xml <- stringToXml(data)
  //     itemsA <- extractItems(xml)
  //   } yield itemsA).fork
  //   fiberB <- (for {
  //     data <- fetchData(feedUrls.last)
  //     xml <- stringToXml(data)
  //     itemsB <- extractItems(xml)
  //   } yield itemsB).fork

  //   itemsA <- fiberA.join
  //   itemsB <- fiberB.join

  //   items = itemsA ++ itemsB
  //   filteredItems <- filterLinesWithKeyword(items, "is")
  //   // _ <- writeFile("sync.txt", filteredItems)
  //   endTime <- Clock.nanoTime
  //   duration = (endTime - startTime).nanos
  //   _ <- Console.printLine(s"Execution time: $duration")
  //   // _ <- Console.printLine(filteredItems.mkString("\n"))
  // } yield ()

  // val program: ZIO[Client, Throwable, Unit] = for {
  //   startTime <- Clock.nanoTime
  //   // items <- ZIO
  //   //   .foreachPar(feedUrls)(feedUrl => // Use ZIO.foreachPar
  //   //     for {
  //   //       data <- fetchData(feedUrl)
  //   //       xml <- stringToXml(data)
  //   //       items <- extractItems(xml)
  //   //     } yield items
  //   //   )
  //   //   .map(_.flatten) // Flatten the list of lists
  //   items <- fetchAllItems(feedUrls)

  //   filteredItems <- filterLinesWithKeyword(items, "is")
  //   // _ <- writeFile("sync.txt", filteredItems)
  //   endTime <- Clock.nanoTime
  //   duration = (endTime - startTime).nanos
  //   _ <- Console.printLine(s"Execution time: $duration")
  //   _ <- Console.printLine(filteredItems.mkString("\n"))
  // } yield ()

  val program: ZIO[Client, Throwable, Unit] = for {
    startTime <- Clock.nanoTime
    items <- fetchAllItems(feedUrls)
    filteredItems <- filterLinesWithKeyword(items, "is")
    endTime <- Clock.nanoTime
    duration = (endTime - startTime).nanos
    _ <- Console.printLine(s"Execution time: $duration")
    _ <- Console.printLine(filteredItems.mkString("\n"))
  } yield ()

  override val run = program.provide(Client.default)
}
