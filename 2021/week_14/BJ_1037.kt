package week_14

fun main() {
    val N = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }

    println(arr.min()!! * arr.max()!!)
}