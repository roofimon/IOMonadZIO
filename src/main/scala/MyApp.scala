import zio._
import zio.Console._

object MyApp extends ZIOAppDefault {
  def run = copyFileContent

  val copyFileContent: ZIO[Any, Throwable, Unit] =
    import FileOperations._
    for {
      lines: List[String] <- readLines("source.txt")
      filteredLines: List[String] <- filterLinesWithKeyword(lines, "ZIO")
      _ <- writeFile("sync.txt", filteredLines)
      _ <- Console.printLine(filteredLines.mkString("\n"))
      _ <- Console.printLine("Data written to file successfully.")
    } yield ()
}
