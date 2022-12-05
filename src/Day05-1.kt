import java.io.File
import java.util.Stack

fun main() {
    val (inp, moves) = File("input", "inp5-1.txt").readText().split("\n\n")
    val inp_split = inp.split("\n")
    val n = inp_split.last().trim().split(" ").last().toInt()
    val stacks: MutableList<Stack<Char>> = mutableListOf()
    repeat(n) {
        stacks.add(Stack<Char>())
    }

    inp_split.asReversed().slice(1 until inp_split.size).forEach {
        it.chunked(4).forEachIndexed { index, symbol ->
            if (symbol.trim().isNotEmpty()) {
                stacks[index].push(symbol.trim()[1])
            }
        }
    }

    moves.split("\n").forEach {
        val splitted = it.split(" ")
        val from = splitted[3].toInt() - 1
        val to = splitted[5].toInt() - 1
        repeat(splitted[1].toInt()){
            stacks[to].push(stacks[from].pop())
        }
    }
    var ans = stacks.fold("") { acc, it ->
        acc + it.pop()
    }
    println(ans)
}