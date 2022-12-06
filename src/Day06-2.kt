fun main() {
    val dist = 14
    val inp = readInput("inp6-1").first()
    for (i in 0 until inp.length - dist) {
        if (inp.slice(i..i + dist - 1).toSet().size == dist) {
            println(i + dist)
            break
        }
    }
}