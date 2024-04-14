import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.FileWriter

fun syllabusParse() {
    val url = "https://web-ext.u-aizu.ac.jp/official/curriculum/syllabus/1_J_000.html"

    try {
        val doc: Document = Jsoup.connect(url).get()
        val links = doc.select("a[href^='2024_1_J_'][href*='.html#SS']")
        for (link in links) {
            FileWriter("syllabus.txt", true).use { it.write("${link.text()}\n") }
            println(link.text())
        }
    } catch (e: Exception) {
        println("Error : ${e.message}")
    }
}
