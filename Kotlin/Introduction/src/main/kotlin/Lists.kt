fun main() {
    immutableList()
    mutableList()
}

fun immutableList() {
    val readOnly : List<String> = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    println(readOnly.size)
    println(readOnly)
    println("First: ${readOnly.first()}")
    println("Last: ${readOnly.last()}")
    println("Filters and Functional Programming")
    val example = readOnly.filter { it.contains("e") }
    println("Filter: $example")
    println("For Each Function")
    readOnly.forEach { day -> println(day) }
}

fun mutableList() {
    val weekDays : MutableList<String> = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    println(weekDays)
    weekDays.add("Random Day")
    println(weekDays)
    weekDays.add(0, "New First Day")
    println(weekDays)
    if (weekDays.isEmpty()) {
        println("Empty list")
    }
    if (weekDays.isNotEmpty()) {
        println("List with elements")
    }
    println("For Loop")
    for ((pos, day) in weekDays.withIndex()) {
        println("$pos -> $day")
    }
    println("Functional Programming")
    weekDays.forEach { day -> println(day) }
}
