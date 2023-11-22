fun main() {
    basicCondition("ahincho")
    basicCondition("Eduardo")
    boolCheck(true)
    boolCheck(false)
    checkAge(19, false)
    checkAge(15, true)
    checkAge(20, true)
}

fun checkAge(age : Int, parentsPermission : Boolean) {
    if (age >= 18 && parentsPermission) {
        println("Beer")
    } else {
        println("Juice")
    }
}

fun boolCheck(condition : Boolean) {
    if (condition) {
        println("True")
    } else {
        println("False")
    }
}

fun basicCondition(name : String) {
    if (name == "Angel") {
        println("Name is equals to Angel")
    } else if (name == "ahincho") {
        println("Name is equals to ahincho")
    } else {
        println("Name isn't equals to Angel")
    }
}