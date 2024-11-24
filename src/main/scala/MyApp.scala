import zio._
import zio.Console._

object MyApp extends ZIOAppDefault {
  // def run = fileOperations

  // def fileOperations: ZIO[Console, Throwable, Unit] = for {
  //   lines <- FileOperations.readLines("example.txt")
  //   _ <- Console.printLine(lines.mkString("\n"))
  // } yield ()
  def run = myAppLogic

  val myAppLogic: ZIO[Any, Throwable, Unit] =
    for {
      lines <- FileOperations.readLines("example.txt")
      _ <- Console.printLine(lines.mkString("\n"))
    } yield ()
}
