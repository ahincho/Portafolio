/**
 * Variables
 */

val num : Int = 30 // Global Scope

fun main() {
    // dataTypes()
    // stringOps()
    showMyName("Angel")
    showMyAge(19)
    add(10, 15)
    val sub = subtract(5, 22)
    println(sub)
}

fun showMyName(name : String) {
    println("Im $name")
}

fun showMyAge(age : Int) {
    println("Im $age years old")
}

fun add(num1 : Int, num2 : Int) {
    println(num1 + num2)
}

fun subtract(num1 : Int, num2 : Int) : Int {
    return num1 - num2
}

fun dataTypes() {
    // Integers (-2.147.483.647 to 2,147,483,647)
    val age : Int = 30
    // Long (-9,223,372,036,854,775,807 to 9,223,372,036,854,775,807)
    val example : Long = 30
    // Float (IEEE Standard for Simple Precision)
    val floatExample : Float = 30.5f
    // Double (IEEE Standard for Double Precision)
    val doubleExample : Double = 3241.3131311
    // Alpha Numeric Variables
    // Char
    val charExampleOne : Char = 'A'
    val charExampleTwo : Char = '2'
    val charExampleThree : Char = '@'
    // Strings
    val stringExample : String = "ahincho"
    // Boolean
    val boolExampleOne : Boolean = true
    val boolExampleTwo : Boolean = false
    println(stringExample)
    // Val or Values are Immutable
    // Var or Variables are Mutable
    var ageTwo : Int = 19
    println(ageTwo)
    // Arithmetic Functions
    println("Arithmetic Functions")
    println(age + ageTwo)
    println(age - ageTwo)
    println(age * ageTwo)
    println(age / ageTwo)
    println(age % ageTwo)
    println(age + floatExample)
    val stringThree = "4"
    val stringFour = "23"
    println(stringThree + stringFour)
    println(stringThree.toInt() + stringFour.toInt())
}

fun stringOps() {
    val stringExample : String = "ahincho"
    var ageTwo : Int = 19
    var stringConcat = "Hello"
    println(stringConcat)
    stringConcat = "Hello Im $stringExample and Im $ageTwo years old"
    println(stringConcat)
}