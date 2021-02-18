package week_07

fun main() {
    val N = readLine()?.toInt() ?: 0

    for (i in 0 until N) {
        var temp = i
        var curr = i

        while (curr > 0) {
            temp += curr % 10
            curr /= 10
        }

        if (temp == N) {
            println(i)
            return
        }
    }

    println(0)
}