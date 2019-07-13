fun main() {
    val tracks = readLine()!!.toInt()
    (1..tracks).forEach {
        val points = readLine()!!.toInt()
        println(Dice.main(points))
    }
}

object Dice {
    fun main(points: Int): Int {
        val threes = if (points % 2 == 0) 0 else 1
        val twos = if (threes > 0) (points - 3) / 2 else points / 2
        return twos + threes
    }
}
