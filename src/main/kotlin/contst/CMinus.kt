import java.lang.IndexOutOfBoundsException

fun main() {
    val queries = readLine()!!.toInt()
    (1..queries).asSequence().map {
        CSolution(CMinus.readString(), CMinus.readString())
    }.forEach { println(CMinus.go(it)) }
}

object CMinus {
    fun go(ns: CSolution): String = ns.go()

    private fun readln() = readLine()!!
    private fun readlnStrings() = readln().split(' ')
    fun readlnLongs() = readlnStrings().map { it.toLong() }
    fun readlnInts() = readlnStrings().map { it.toInt() }
    private fun isWhiteSpace(c: Char) = c in " \r\n\t"
    fun readString() = generateSequence { System.`in`.read().toChar() }
        .dropWhile { isWhiteSpace(it) }.takeWhile { !isWhiteSpace(it) }.joinToString("")
    private fun readLong() = readString().toLong()
    fun readLongs(n: Int) = generateSequence { readLong() }.take(n)
}

data class CSolution(val a: String, val b: String) {
    fun go(): String {
        var sol = "YES"
        var offset = 0
        var offsetDiff = 0
        val alength = a.length
        val blength = b.length
        while (sol == "YES" && (alength > offset + offsetDiff || blength > offset)) {
            sol = try {
                when {
                    a[offset + offsetDiff] == b[offset] -> "YES"
                    a[offset + offsetDiff] == '+' -> "NO"
                    a[offset + offsetDiff + 1] == '-' -> {
                        offsetDiff++
                        if (b[offset] == '+' ) "YES" else "NO"
                    }
                    else -> "NO"
                }
            } catch (ex: IndexOutOfBoundsException) {
                "NO"
            }
            offset++
        }
        return sol
    }
}
