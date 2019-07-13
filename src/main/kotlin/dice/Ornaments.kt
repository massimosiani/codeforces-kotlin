import kotlin.math.min

fun main() {
    val ns = Ornaments.readlnInts()
    println(Ornaments.main(ns[0], ns[1], ns[2]))
}

object Ornaments {
    fun main(yellow: Int, blue: Int, red: Int): Int {
        var myYellow = min(yellow, blue - 1)
        myYellow = min(myYellow, red - 2)

        return 3 * myYellow + 3
    }

    private fun readln() = readLine()!!
    private fun readlnStrings() = readln().split(' ')
    fun readlnInts() = readlnStrings().map { it.toInt() }
}
