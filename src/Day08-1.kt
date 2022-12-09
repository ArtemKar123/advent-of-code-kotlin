import kotlin.math.max

fun main() {
    val map = readInput("inp8").map { it.chunked(1).map { x -> x.toInt() } }


    val Tmap = MutableList<MutableList<Int>>(map.size) { MutableList<Int>(map.first().size) { 0 } }
    for (i in 0 until map.size) {
        for (j in 0 until map.size) {
            Tmap[i][j] = map[j][i]
        }
    }
    val trees: MutableSet<Pair<Int, Int>> = mutableSetOf()
    listOf(Pair(map, true), Pair(Tmap, false)).forEach() { mit ->
        mit.first.forEachIndexed() { lindex, line ->
            var c = 0
            var max = line.first()
            for (i in 1..line.size - 1) {
                if (line[i] > max) {
                    max = line[i]
                    c++
                    if (mit.second) {
                        trees.add(Pair(lindex, i))
                    } else {
                        trees.add(Pair(i, lindex))
                    }
                }
            }

            max = line.last()
            for (i in line.size - 1 downTo 0) {
                if (line[i] > max) {
                    max = line[i]
                    c++
                    if (mit.second) {
                        trees.add(Pair(lindex, i))
                    } else {
                        trees.add(Pair(i, lindex))
                    }
                }
            }
        }
    }
    println(trees.filter {
        0 < it.first && it.first < map.size - 1 &&
                0 < it.second && it.second < map.size - 1
    }.size + map.size * 4 - 4)
}