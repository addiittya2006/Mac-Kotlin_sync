package xyz.addiittya.basic

/**
 * Created by addiittya on 24/06/16.
 */

//You can do that in IntelliJ by editing the Run Configurations and providing args in Arguments Section.

fun main(args: Array<String>) {
    if (args.size == 0) {
        println("Please provide a name as a command-line argument")
        return
    }
    println("Hello, ${args[0]}! from Kotlin")
}