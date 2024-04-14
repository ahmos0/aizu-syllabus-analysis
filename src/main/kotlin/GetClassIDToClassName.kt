import java.io.FileReader

fun getClassIDToClassName(): HashMap<String, String>{
    FileReader("syllabus.txt").use { reader ->
        val lines = reader.readLines()
        val classIDToClassName = HashMap<String, String>()
        for (line in lines) {
            val classID = line.substringBefore(" ")
            val className = line.substringAfter(" ")
            classIDToClassName[classID] = className
        }
        return classIDToClassName
    }
}