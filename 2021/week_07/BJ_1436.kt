package week_07

fun main() {
    val N = readLine()?.toInt()
    var i = 666
    val list = ArrayList<Int>()

    while (true) {
        if (i.toString().contains("666")) {
            list.add(i)
        }
        i++

        if (list.size == N) {
            print(list.last())
            return
        }
    }
}