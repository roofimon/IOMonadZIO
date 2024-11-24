import zio._
import zio.stream.ZStream
import scala.io.Source

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
}
