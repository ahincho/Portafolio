fun main() {
    // First Comment Here
    /*
    * Multiline
    * Comment
    */
    println("Hello World!")
    // 1. Variables
    var myString = "Sequence of chars"
    myString = "Modified sequence of chars"
    println(myString)
    // 2. Data Types
    // Strings
    var otherString : String = "Another string"
    println(otherString)
    // Integers
    var myInt : Int = 8
    myInt = myInt + 4
    println(myInt)
    println(myInt - 2)
    var otherInt = 5
    println(myInt)
    // Doubles
    var myDouble : Double = 6.5
    myDouble = 6.0
    println(myDouble)
    // Float
    var myFloat : Float = 6.5f
    println(myFloat)
    // Booleans
    var myBool = true
    println(myBool)
    myBool = false
    println(myBool)
    // 3. Constants
    val myConst = "Constant Value"
    // myConst = "New Constant" Cant modify the constant
    // 4. Flow Control
    myInt = 11
    myString = "World"
    if (myInt == 12 && myString == "Hello") {
        println("Integer Value is 12")
    } else if (myInt == 10 || myString == "World") {
        println("Integer Value is 10")
    } else {
        println("Integer Value isn't 12")
    }
}