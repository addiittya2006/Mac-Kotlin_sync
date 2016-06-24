package xyz.addiittya.loop

/**
 * Created by addiittya on 24/06/16.
 */

fun main(args: Array<String>) {
    for (name in args)
        println("Hello, $name!")

    for (i in args.indices)
        print(args[i]+"\n")
}