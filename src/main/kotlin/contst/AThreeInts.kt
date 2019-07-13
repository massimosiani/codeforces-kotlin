import java.math.BigInteger

fun main() {
    val queries = readLine()!!.toInt()
    (1..queries).forEach {
        val ns = AThreeInts.readlnInts()
        println(AThreeInts.go(ns[0].toBigInteger(), ns[1].toBigInteger()))
    }
}

object AThreeInts {
    fun go(x: BigInteger, y: BigInteger): String {
        return sequenceOf(
            Solution(BigInteger.ONE, x-BigInteger.ONE, y-BigInteger.ONE),
            Solution(BigInteger.ONE, x-BigInteger.ONE, y-x+BigInteger.ONE),
            Solution(BigInteger.ONE, x-y+BigInteger.ONE, y-BigInteger.ONE),
            if (x == y) Solution(BigInteger.ONE, BigInteger.ONE, x-BigInteger.ONE) else Solution(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO))
            .filter { it.ok }
            .minBy { it.sum }
            .toString()
    }

    private fun readln() = readLine()!!
    private fun readlnStrings() = readln().split(' ')
    fun readlnInts() = readlnStrings().map { it.toInt() }
}

data class Solution(val a: BigInteger, val b: BigInteger, val c: BigInteger) {
    val ok = a > BigInteger.ZERO && b > BigInteger.ZERO && c > BigInteger.ZERO
    val sum = a + b + c

    override fun toString() = "${a.intValueExact()} ${b.intValueExact()} ${c.intValueExact()}"
}
