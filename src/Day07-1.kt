import java.util.NoSuchElementException

const val MAX_SIZE = 100000

class Node(var size: Int = 0, private val parent: Node? = null) {
    val children: MutableMap<String, Node> = mutableMapOf()
    fun getParent(): Node {
        return parent ?: this
    }
}

fun countSizes(node: Node): Int {
    node.size += node.children.values.fold(0) { acc, it ->
        acc + countSizes(it)
    }
    return node.size
}

fun flatten(node: Node): List<Node> {
    return listOf(node) + node.children.values.fold(listOf()) { acc, it -> acc + flatten(it) }
}

fun parse(filename: String, root: Node): Node {
    var curNode = root
    readInput(filename).forEach {
        val tokens = it.split(" ")
        if (it.first() == '$') {
            if (tokens[1] == "cd") {
                if (tokens[2] == "/") {
                    curNode = root
                } else if (tokens[2] == "..") {
                    curNode = curNode.getParent()
                } else {
                    if (!curNode.children.contains(tokens[2])) {
                        curNode.children[tokens[2]] = Node(parent = curNode)
                    }
                    curNode = curNode.children[tokens[2]] ?: throw NoSuchElementException(tokens[2])
                }
            }
        } else {
            if (tokens[0] == "dir") {
                curNode.children[tokens[1]] = Node(parent = curNode)
            } else {
                curNode.children[tokens[1]] = Node(size = tokens[0].toInt(), parent = curNode)
            }
        }
    }
    return root
}

fun main() {
    val root = Node()
    parse("inp7-1", root)
    countSizes(root)
    println(flatten(root).filter { it.size < MAX_SIZE && it.children.isNotEmpty() }.sumOf { it.size })
}