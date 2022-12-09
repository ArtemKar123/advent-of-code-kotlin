import java.util.NoSuchElementException
import kotlin.math.abs
import kotlin.math.sign

val moves: Map<Char, Pair<Int, Int>> =
    mapOf('R' to Pair(0, 1), 'L' to Pair(0, -1), 'U' to Pair(1, 0), 'D' to Pair(-1, 0))

fun main() {
    var H = Pair(0, 0)
    var T = Pair(0, 0)
    val visited: MutableSet<Pair<Int, Int>> = mutableSetOf()
    readInput("inp9").forEach {
        val s = it.split(" ")
        val d = moves[s[0].first()] ?: throw NoSuchElementException(s[0])
        repeat(s[1].toInt()) {
            H = Pair(H.first + d.first, H.second + d.second)
            if (abs(H.first - T.first) > 1 || abs(H.second - T.second) > 1) {
                if (H.first != T.first) {
                    T = Pair(T.first + (H.first - T.first).sign, T.second)
                }
                if (H.second != T.second){
                    T = Pair(T.first, T.second + (H.second - T.second).sign)
                }
            }
            visited.add(T)
        }
    }
    println(visited.size)
}