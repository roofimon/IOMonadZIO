import zio._
import zio.Console._

object MyApp extends ZIOAppDefault {
  def run = myAppLogic

  val myAppLogic: ZIO[Any, Throwable, Unit] =
    for {
      lines <- FileOperations.readLines("example.txt")
      _ <- Console.printLine(lines.mkString("\n"))
    } yield ()
}
