import zio._
import zio.stream.ZStream
import scala.io.Source
import java.io.{File, PrintWriter}

object FileOperations {

  def readFile(filePath: String): ZStream[Any, Throwable, String] = {
    ZStream
      .acquireReleaseWith(ZIO.attempt(Source.fromFile(filePath)))(source =>
        ZIO.attempt(source.close()).orDie
      )
      .flatMap(source => ZStream.fromIterator(source.getLines()))
  }

  def readLines(filePath: String): ZIO[Any, Throwable, List[String]] = {
    readFile(filePath).runCollect.map(_.toList)
  }

  def filterLinesWithKeyword(
      lines: List[String],
      keyword: String
  ): ZIO[Any, Throwable, List[String]] = {
    ZIO.attempt { lines.filter(_.contains(keyword)) }
  }

  def writeFile(
      filePath: String,
      lines: List[String]
  ): ZIO[Any, Throwable, Unit] = {
    ZIO.acquireReleaseWith(ZIO.attempt(new PrintWriter(new File(filePath))))(
      writer => ZIO.attempt(writer.close()).orDie
    ) { writer =>
      ZIO.foreach(lines)(line => ZIO.attempt(writer.println(line))).unit
    }
  }

}
