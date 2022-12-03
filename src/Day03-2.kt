import java.io.BufferedReader
import java.io.File
import java.util.PriorityQueue
import java.util.Vector
import kotlin.math.max

fun main() {
    println(readInput("inp3-2").chunked(3).fold(0) { acc, chunk ->
        acc + chunk[0].fold(Pair<Int, Boolean>(0, false)) { c, letter ->
            if (!c.second && chunk[1].contains(letter) && chunk[2].contains(letter)
            ) {
                Pair(if (letter.isUpperCase()) (letter - 'A' + 27) else (letter - 'a' + 1), true)
            } else Pair(c.first, false)
        }.first
    })
}