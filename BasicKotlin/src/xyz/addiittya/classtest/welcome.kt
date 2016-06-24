package xyz.addiittya.classtest

/**
 * Created by addiittya on 24/06/16.
 */

class Welcome(val name: String) {

    constructor() : this("Default Constructor")

    fun greet() {
        println("Hello, ${name}");
    }

}

fun main(args: Array<String>) {

    Welcome().greet()
    Welcome(if (args.size == 0) "with No Args" else args[0]).greet()

}