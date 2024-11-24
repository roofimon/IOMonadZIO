val lines = List(
  "Hello, world!",
  "This is an example.",
  "Scala is powerful.",
  "Functional programming is great.",
  "ZIO makes Scala even better!"
)
val keyword = "Scala"
// Filter the list based on the keyword
val filteredLines: List[String] = lines.filter(_.contains(keyword))

// Print the filtered lines println("Filtered lines:")
filteredLines.foreach(println)
