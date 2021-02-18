package week_07

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())


    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.sorted()

    var tot = 0

    arr.forEachIndexed { i, item1 ->
        arr.forEachIndexed { j, item2 ->
            if (j == i) {
                return@forEachIndexed
            }
            arr.forEachIndexed { k, item3 ->
                if (k == i || k == j) {
                    return@forEachIndexed
                }

                val temp = item1 + item2 + item3
                if (temp <= M) {
                    tot = max(temp, tot)
                }
            }
        }
    }

    println(tot)
}