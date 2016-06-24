package xyz.addiittya.multi

/**
 * Created by addiittya on 24/06/16.
 */

fun main(args: Array<String>) {
    val pair = Triplets(1, "one", "Aditya")

    val (num, word, name) = pair

    println("num = $num, word = $word, name = $name")
}

class Triplets<K, V, J>(val first: K, val second: V, val third: J) {
    operator fun component1(): K {
        return first
    }

    operator fun component2(): V {
        return second
    }

    operator fun component3(): J {
        return third
    }
}