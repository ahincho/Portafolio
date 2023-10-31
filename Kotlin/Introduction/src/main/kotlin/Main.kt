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
    // 5. Lists
    // Immutable List
    var myList = listOf<String>("Angel", "Hincho", "ahincho")
    println(myList)
    // Mutable List
    val otherList = mutableListOf<String>("Angel", "Hincho", "ahincho")
    println(otherList)
    otherList.add(1,"Eduardo")
    println(otherList)
    // 6. Sets
    val mySet = setOf<String>("Angel", "ahincho", "Hincho", "ahincho")
    println(mySet)
    // 7. Maps
    val myMap = mutableMapOf("Angel" to 19, "Fabiola" to 27, "Darwin" to 21)
    println(myMap["Fabiola"])
    println(myMap["Angel"])
    println(myMap["Darwin"])
    myMap["Samir"] = 20
    println(myMap["Samir"])
    // 8. Loops
    // For Loop
    for (value in myList) {
        println(value)
    }
    for (maplet in myMap) {
        println(maplet)
    }
    var myCounter = 0
    // While Loop
    while (myCounter < myList.count()) {
        println(myList[myCounter])
        myCounter++
        myFunction()
    }
    // 9. Optionals
    var myOptional : String? = null
    println(myOptional)
    myOptional = "Angel"
    println(myOptional)
    // 10. Functions
    myFunction()
    myFunction()
    myFunction()
    // 11. Classes
    var client = Person("Angel", 19)
    println("Creationg somes classes")
    println(client.name)
    client.gretting()
}

// Functions
fun myFunction() {
    println("This is a function")
}

// Classes
class Person(val name : String, val age : Int) {

    fun gretting() {
        println("Hello Person!")
    }

}