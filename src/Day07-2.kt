import java.util.NoSuchElementException

const val CAPACITY = 70000000
const val NEEDED = 30000000

private val root = Node()

fun main() {
    val root = Node()
    parse("inp7-2", root)
    countSizes(root)
    val MIN_SPACE = NEEDED - (CAPACITY - root.size)
    println(flatten(root).filter { it.size > MIN_SPACE && it.children.isNotEmpty() }.minBy { it.size }.size)
}