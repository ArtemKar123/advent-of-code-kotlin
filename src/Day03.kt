import java.io.BufferedReader
import java.io.File
import java.util.PriorityQueue
import java.util.Vector
import kotlin.math.max

fun main() {
    println(readInput("inp3-1").fold(0) { acc, it ->
        acc + it.slice(0 until it.length / 2).fold(Pair<Int, MutableSet<Char>>(0, mutableSetOf())) { c, letter ->
            Pair(
                c.first + (if (!c.second.contains(letter) && it.slice(it.length / 2 until it.length)
                        .contains(letter)
                ) {
                    c.second.add(letter);
                    1
                } else 0) * (if (letter.isUpperCase()) (letter - 'A' + 27) else (letter - 'a' + 1)), c.second
            )
        }.first
    })
}