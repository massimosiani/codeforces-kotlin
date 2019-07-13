fun main() {
    val queries = readLine()!!.toInt()
    val ns = BDays.readLongs(queries)
    println(BDays.go(ns))
}

object BDays {
    fun go(ns: Sequence<Long>): String = ns
            .fold(BSolution(0, 0, 0)) { acc, n ->
                if (acc.isBad(n)) acc.withBad(n) else acc.addDay(n)
            }
            .toString()

    private fun readln() = readLine()!!
    private fun readlnStrings() = readln().split(' ')
    fun readlnLongs() = readlnStrings().map { it.toLong() }
    fun readlnInts() = readlnStrings().map { it.toInt() }
    private fun isWhiteSpace(c: Char) = c in " \r\n\t"
    private fun readString() = generateSequence { System.`in`.read().toChar() }
        .dropWhile { isWhiteSpace(it) }.takeWhile { !isWhiteSpace(it) }.joinToString("")
    private fun readLong() = readString().toLong()
    fun readLongs(n: Int) = generateSequence { readLong() }.take(n)
}

data class BSolution(val a: Long, val b: Long, val cs: Long) {
    fun addDay(d: Long): BSolution {
        val (a, b) = if (a > b) N(a, d) else N(b, d)
        return copy(a = a, b = b)
    }
    fun isBad(d: Long) = d < a && d < b
    fun withBad(d: Long) = copy(cs = cs + 1)

    override fun toString() = cs.toString()
}

data class N(val a: Long, val b: Long)
