import kotlin.math.max

fun main() {
    val map = readInput("inp8").map { it.chunked(1).map { x -> x.toInt() } }
    val res = map.mapIndexed { i, line ->
        line.mapIndexed { j, it ->
            val h = it
            var r = 1
            var c = 0
            for (i_ in i + 1 until map.size) {
                c++
                if (map[i_][j] >= h)
                    break
            }

            r *= c
            c = 0

            for (i_ in i - 1 downTo 0) {
                c++
                if (map[i_][j] >= h)
                    break
            }

            r *= c
            c = 0

            for (j_ in j + 1 until map.size) {
                c++
                if (map[i][j_] >= h)
                    break
            }

            r *= c
            c = 0

            for (j_ in j - 1 downTo 0) {
                c++
                if (map[i][j_] >= h)
                    break
            }

            r *= c

            r
        }
    }
    println(res.flatten().max())
}