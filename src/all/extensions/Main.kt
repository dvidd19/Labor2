package extensions

fun main() {
    val name = "John Smith"
    println(name.monogram())

    val list: List<String> = listOf("apple", "pear", "melon")
    println(list.joinedBySeparator("#"))

    val list2: List<String> = listOf("apple", "pear", "strawberry", "melon")
    println(list2.longestString())
}

// 1.
fun String.monogram() = this.split(" ").map { it.first() }.joinToString("")

// 2.
fun List<String>.joinedBySeparator(separator: String) = this.joinToString(separator) { it }

// 3.
fun List<String>.longestString() = this.maxOf { it }