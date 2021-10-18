package dictionary
import java.io.File
import dictionary.DictionaryProvider.Companion.createDictionary
import dictionary.DictionaryType.*
import java.io.FileNotFoundException;
fun main() {
    val dict: IDictionary = createDictionary(ARRAY_LIST)
    println("Number of words: ${dict.size()}")
    var word: String?
    while (true) {
        print("What to find? ")
        word = readLine()
        if (word.equals("quit")) {
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }
}