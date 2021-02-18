package week_07

import java.util.*

fun main() {
    val st = StringTokenizer(readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val board = Array(N) {
        val line = readLine()?.split("") ?: emptyList()
        Array(M) {
            line[it + 1]
        }
    }


    val newBoard = Array(8) {
        Array(8) {
            ""
        }
    }

    var result = 63

    for (i in 0 until N) {
        if (i + 8 > N) {
            break
        }

        for (j in 0 until M) {
            if (j + 8 > M) {
                break
            }

            for (p in 0 until 8) {
                for (q in 0 until 8) {
                    newBoard[p][q] = board[i + p][j + q]
                }
            }

            var white = 0
            var black = 0

            var curr: String
            newBoard.forEachIndexed { index, item ->
                curr = if (index % 2 == 0) {
                    "W"
                } else {
                    "B"
                }

                item.forEach { color ->
                    if (color != curr) {
                        white++
                    }

                    curr = if (curr == "W") {
                        "B"
                    } else {
                        "W"
                    }
                }
            }

            newBoard.forEachIndexed { index, item ->
                curr = if (index % 2 == 0) {
                    "B"
                } else {
                    "W"
                }

                item.forEach { color ->
                    if (color != curr) {
                        black++
                    }

                    curr = if (curr == "W") {
                        "B"
                    } else {
                        "W"
                    }
                }
            }

            result = minOf(result, white, black)
        }
    }

    print(result)
}
