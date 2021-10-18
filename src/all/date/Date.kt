package date

import kotlin.random.Random

data class Date(val year: Int, val month: Int, val day: Int) : Comparable<Date> {
    override fun compareTo(other: Date) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> day - other.day
    }
}

class CompareByYear : Comparator<Date> {
    override fun compare(o1: Date?, o2: Date?): Int {
        if (o1 == null || o2 == null) {
            return 0;
        }
        return o1.year - o2.year
    }
}

val days: HashMap<Int, Int> = hashMapOf(
    1 to 31,
    2 to 28,
    3 to 31,
    4 to 30,
    5 to 31,
    6 to 30,
    7 to 31,
    8 to 31,
    9 to 30,
    10 to 31,
    11 to 30,
    12 to 31
)

fun main() {
    val compareByYear = CompareByYear()
    val randomDateList = arrayListOf<Date>()

    while (randomDateList.size != 10) {
        val date = Date(Random.nextInt(1582, 2100), Random.nextInt(0, 20), Random.nextInt(0, 40))
        if (date.isValid()) {
            randomDateList.add(date)
        } else {
            println("Invalid date: ${date.year}.${date.month}.${date.day}")
        }
    }

    println("****************************\nValid Dates: ${randomDateList.size}\n****************************")
    randomDateList.forEach { println("${it.year}.${it.month}.${it.day} ${if (it.isLeapYear()) "-> leap year" else ""}") }

    println("****************************\nSorted\n****************************")
    randomDateList.sort()
    randomDateList.forEach { println("${it.year}.${it.month}.${it.day}") }

    println("****************************\nReversed\n****************************")
    randomDateList.reverse()
    randomDateList.forEach { println("${it.year}.${it.month}.${it.day}") }

    println("****************************\nSorted by Year\n****************************")
    randomDateList.sortWith(compareByYear)
    randomDateList.forEach { println("${it.year}.${it.month}.${it.day}") }
}

fun Date.isLeapYear() = if (this.year % 4 == 0) if (this.year % 100 == 0) this.year % 400 == 0 else true else false

fun Date.isValid(): Boolean {
    when {
        this.year < 0 || this.month < 0 || this.day < 0 -> return false
        this.month !in 1..12 -> return false
        this.isLeapYear() && this.month == 2 && this.day !in 1..29 -> return false
        this.isLeapYear() && this.month != 2 && this.day !in 1..days[this.month]!! -> return false
        !this.isLeapYear() && this.day !in 1..days[this.month]!! -> return false
    }
    return true
}