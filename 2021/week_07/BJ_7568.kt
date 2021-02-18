package week_07

import java.util.*

fun main() {
    val N = readLine()?.toInt() ?: 0
    val list = arrayListOf<BodySize>().apply {
        for (i in 0 until N) {
            val st = StringTokenizer(readLine() ?: continue)
            add(BodySize(st.nextToken().toInt(), st.nextToken().toInt(), 1, i))
        }
    }

    list.forEach { item1 ->
        list.forEach { item2 ->
            if (item1 < item2) {
                item1.rank++
            }
        }
    }

    Array(N) { pos ->
        list.find { it.position == pos }?.rank ?: 0
    }.forEach {
        println(it)
    }
}

data class BodySize(
    val weight: Int,
    val height: Int,
    var rank: Int,
    val position: Int
) : Comparable<BodySize> {
    override fun compareTo(other: BodySize): Int {
        return if (weight > other.weight && height > other.height) {
            1
        } else if (weight < other.weight && height < other.height) {
            -1
        } else {
            0
        }
    }
}