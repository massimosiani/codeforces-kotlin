fun main() {
    val queries = readLine()!!.toInt()
    val ns = DDecoding.readlnInts()
    val empties = ns.asSequence().filter { it == -1 }.map { listOf<Int>() }.toMutableList()
    val s = ns.fold(DSolution(empties, 0, listOf())) { acc, n ->
        acc.insert(n)
    }
    println(empties.size)
    println(s.toString())
}

object DDecoding {
    private fun readln() = readLine()!!
    private fun readlnStrings() = readln().split(' ')
    fun readlnLongs() = readlnStrings().map { it.toLong() }
    fun readlnInts() = readlnStrings().map { it.toInt() }
    private fun isWhiteSpace(c: Char) = c in " \r\n\t"
    fun readString() = generateSequence { System.`in`.read().toChar() }
        .dropWhile { isWhiteSpace(it) }.takeWhile { !isWhiteSpace(it) }.joinToString("")
    private fun readLong() = readString().toLong()
    private fun readInt() = readString().toInt()
    fun readLongs(n: Int) = generateSequence { readLong() }.take(n)
    fun readInts(n: Int) = generateSequence { readInt() }.take(n)
}

data class DSolution(private val lines: MutableList<List<Int>>, val currentLine: Int, val skippedLines: List<Int>) {
    fun insert(n: Int): DSolution =
        when(n) {
            -1 -> copy(currentLine = nextLine(currentLine), skippedLines = skippedLines + currentLine)
            else -> copy(lines = addToLine(n), currentLine = nextLine(currentLine))
        }

    private fun addToLine(n: Int): MutableList<List<Int>> {
        lines[currentLine] = lines[currentLine] + n
        return lines
    }

    private tailrec fun nextLine(line: Int): Int =
        if (skippedLines.contains((line + 1) % lines.size)) nextLine((line + 1) % lines.size)
        else (line + 1) % lines.size

    override fun toString(): String =
        lines.joinToString(separator = "\n") { "${it.size} ${it.joinToString(separator = " ")}" }
}
