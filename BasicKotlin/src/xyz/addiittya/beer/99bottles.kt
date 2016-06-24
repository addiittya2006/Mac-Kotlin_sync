package xyz.addiittya.beer

/**
 * Created by addiittya on 24/06/16.
 */

// TODO Using Inline Expressions
//fun main(args: Array<String>) = 99 downTo 0 step 1 map {} forEach {}

fun main(args: Array<String>) {
    for (i in 99 downTo 0 step 1) { println(verse(i)) }
}

fun verse(n: Int) = when (n) {
    0 -> """${n.bottles()} of beer on the wall, ${n.bottles()} of beer.
Go to the store and buy some more, ${99.bottles()} of beer on the wall."""

    else -> """${n.bottles()} of beer on the wall, ${n.bottles()} of beer.
Take one down and pass it around, ${(n - 1).bottles()} of beer on the wall.
"""
}

fun Int.bottles() = when (this) { 0 -> "no more bottles" 1 -> "1 bottle" else -> "$this bottles" }
