fun main() {
    // Arrays
    val weekDays = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    println(weekDays[6])
    println(weekDays.size)
    weekDays[0] = "Reassigned Monday"
    println(weekDays[0])
    if (weekDays.size >= 8) {
        println(weekDays[8])
    } else {
        println("Week days array is too short")
    }
    // Loops
    println("Recover indexes")
    for (index in weekDays.indices) {
        println(index)
    }
    println("For loop")
    for (day in weekDays) {
        println(day)
    }
    println("For loop with index")
    for ((position, value) in weekDays.withIndex()) {
        println("Position: $position -> $value")
    }
}