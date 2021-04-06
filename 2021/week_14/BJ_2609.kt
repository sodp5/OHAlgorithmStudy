package week_14

fun main() {
    val splits = readLine()!!.split(" ")
    val max = splits.max()!!.toInt()
    val min = splits.min()!!.toInt()

    var cgys = 0

    for (i in 1 until min + 1) {
        if (min % i == 0 && max % i == 0) {
            cgys = i
        }
    }

    println(cgys)
    println(max * min / cgys)
}