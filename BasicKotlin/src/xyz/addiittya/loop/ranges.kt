package xyz.addiittya.loop

/**
 * Created by addiittya on 24/06/16.
 */

fun main(args: Array<String>) {

    val x = Integer.parseInt(if (args.size != 0) args[0] else "2")
    val y = 10
    if (x in 1..y - 1)
        println("OK")

    for (a in 1..5)
        print("$a ")

    println()
    val array = arrayListOf<String>()
    array.add("aditya")
    array.add("addiittya")
    array.add("addiittya2006")

    if (x !in 0..array.size - 1)
        println("Out: array has only ${array.size} elements. x = $x")

    //Check if a collection contains an object:
    if ("add" in array) // collection.contains(obj) is called
        println("Yes: array contains add")

    if ("ddd" in array) // collection.contains(obj) is called
        println("Yes: array contains ddd")
    else
        println("No: array doesn't contains ddd")
}