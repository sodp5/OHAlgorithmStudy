package week_14

import java.lang.StringBuilder
import java.util.*

fun main() {
    val sb = StringBuilder()
    while (true) {
        val st = StringTokenizer(readLine())
        val N = st.nextToken().toInt()
        val M = st.nextToken().toInt()

        if (N == 0 && M == 0) {
            println(sb.toString())
            return
        }

        var neither = true

        if (N > M) {
            if (N % M == 0) {
                sb.append("multiple\n")
                neither = false
            }
        } else {
            if (M % N == 0) {
                sb.append("factor\n")
                neither = false
            }
        }

        if (neither) {
            sb.append("neither\n")
        }
    }
}