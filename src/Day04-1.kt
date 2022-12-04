fun main() {
    println(readInput("inp4-1").fold(0) { acc, it ->
        val ranges = it.split(",").map { it.split("-").map { it.toInt() } }.sortedBy { it[0] }
        assert(ranges[0][0] <= ranges[1][0])
        if ((ranges[0][0] <= ranges[1][0] && ranges[0][1] >= ranges[1][1])) {
            acc + 1
        } else acc
    })
}