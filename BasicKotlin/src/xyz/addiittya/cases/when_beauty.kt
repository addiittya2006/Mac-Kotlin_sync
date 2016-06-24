package xyz.addiittya.cases

/**
 * Created by addiittya on 24/06/16.
 */

fun main(args: Array<String>) {
    cases("Hello")
    cases(1)
    cases(System.currentTimeMillis())
    cases(MyClass())
    cases("hello")
}

fun cases(obj: Any) {
    when (obj) {
        1 -> println("Integer")
        "Hello" -> println("Welcome")
        is Long -> println("Long")
        is String -> print("is a String")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}

class MyClass() {
}