import java.util.NoSuchElementException
import kotlin.math.abs
import kotlin.math.sign

fun main() {
    var T = MutableList<Pair<Int, Int>>(10) { Pair(0, 0) }
    val visited: MutableSet<Pair<Int, Int>> = mutableSetOf()
    readInput("inp9").forEach {
        val s = it.split(" ")
        val d = moves[s[0].first()] ?: throw NoSuchElementException(s[0])
        repeat(s[1].toInt()) {
            T[0] = Pair(T.first().first + d.first, T.first().second + d.second)
            for (i in 1 until T.size) {
                val t = T[i]
                val prev = T[i - 1]
                if (abs(prev.first - t.first) > 1 || abs(prev.second - t.second) > 1) {
                    if (prev.first != t.first) {
                        T[i] = Pair(T[i].first + (prev.first - T[i].first).sign, T[i].second)
                    }
                    if (prev.second != t.second){
                        T[i] = Pair(T[i].first ,T[i].second + (prev.second - T[i].second).sign)
                    }
                }
            }
            visited.add(T.last())
        }
    }
    println(visited.size)
}