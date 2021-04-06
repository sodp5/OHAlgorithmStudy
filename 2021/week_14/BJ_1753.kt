package week_14

import java.util.*
import kotlin.collections.HashMap

fun main() {
    val st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val start = readLine()!!.toInt()

    val map = Array(N + 1) {
        HashMap<Int, Int>()
    }

    repeat(M) {
        StringTokenizer(readLine()).run {
            val y = nextToken().toInt()
            val x = nextToken().toInt()
            val v = nextToken().toInt()

            map[y][x] = v
        }
    }

    val dp = IntArray(N + 1) {
        20001
    }
    dp[start] = 0

    val visit = Array(N + 1) {
        HashMap<Int, Boolean>()
    }

    val queue: Queue<Int> = LinkedList()
    queue.offer(start)

    while (queue.isNotEmpty()) {
        val v = queue.poll()

        for (i in 1 until N + 1) {
            if (!visit[i].getOrDefault(v, false) && !visit[v].getOrDefault(i, false)
                && map[v][i] != 20001 && dp[i] >= map[v].getOrDefault(i, 20001) + dp[v]) {
                dp[i] = map[v].getOrDefault(i, 20001) + dp[v]
                visit[v][i] = true
                visit[i][v] = true
                queue.offer(i)
            }
        }
    }

    dp.forEachIndexed { index, i ->
        if (index == 0) {
            return@forEachIndexed
        }

        if (i == 20001) {
            println("INF")
        } else {
            println(i)
        }
    }
}