package xyz.addiittya.basic

/**
 * Created by addiittya on 24/06/16.
 */

fun main(args: Array<String>) {
    println(getStringLength("Aditya"))
    println(getStringLength(1))
}

fun getStringLength(obj: Any): Int? {
    // Once Tested with "is" No cast Needed to String
    if (obj is String)
        return obj.length
    return null
}