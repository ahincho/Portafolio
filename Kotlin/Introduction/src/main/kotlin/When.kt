fun main() {
    getMonth(10)
    getMonth(12)
    getMonth(16)
    getTrimester(4)
    getTrimester(8)
    getTrimester(14)
    getSemester(6)
    getSemester(7)
    getSemester(0)
    result(5)
    result("Angel")
    result(true)
    result(false)
}

fun getMonth(month : Int) {
    when (month) {
        1 -> println("January")
        2 -> println("February")
        3 -> println("March")
        4 -> println("April")
        5 -> println("May")
        6 -> println("June")
        7 -> println("July")
        8 -> println("August")
        9 -> println("September")
        10 -> println("October")
        11 -> println("November")
        12 -> {
            println("December")
            println("Christmas")
        }
        else -> println("No valid month")
    }
}

fun getTrimester(month : Int) {
    when (month) {
        1, 2, 3 -> println("First Trimester")
        4, 5, 6 -> println("Second Trimester")
        7, 8, 9 -> println("Third Trimester")
        10, 11, 12 -> println("Fourth Trimester")
        else -> println("No valid month")
    }
}

fun getSemester(month : Int) {
    when (month) {
        in 1 .. 6 -> println("First Semester")
        in 7 .. 12 -> println("Second Semester")
        !in 1 .. 12 -> println("No valid month")
    }
}

fun result(value : Any) {
    when (value) {
        is Int -> println(value + value)
        is String -> println(value)
        is Boolean -> if (value) println("Happy") else println("Sad")
    }
}
