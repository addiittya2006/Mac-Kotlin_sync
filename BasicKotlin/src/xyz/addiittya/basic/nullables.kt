package xyz.addiittya.basic

/**
 * Created by addiittya on 24/06/16.
 */

// Return null if str does not hold a number
fun parseInt(str: String): Int? {
    try {
        return Integer.parseInt(str)
    } catch (e: NumberFormatException) {
        println("One of the arguments isn't Int")
    }
    return null
}

fun main(args: Array<String>) {
    if (args.size < 2) {
        println("No number supplied");
    } else {
        val x = parseInt(args[0])
        val y = parseInt(args[1])

//        Nullables Handled else the operation would not be possible
        if (x != null && y != null ) {
            print(x*y) // Now we can
        } else {
            println("One of the arguments is null")
        }
    }
}