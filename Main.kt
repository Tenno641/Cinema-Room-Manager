fun cinemaHall() {
    println("""
        Cinema:
          1 2 3 4 5 6 7 8
        1 S S S S S S S S
        2 S S S S S S S S
        3 S S S S S S S S
        4 S S S S S S S S
        5 S S S S S S S S
        6 S S S S S S S S
        7 S S S S S S S S
    """.trimIndent())
}

const val tenDollars = 10
const val eightDollars = 8

fun main() {
    cinemaHall()

    println("Enter the number of rows:")
    val rows = readln().toInt()

    println("Enter the number of seats in each row:")
    val cols = readln().toInt()

    println("Total income:")
    print(when {
        rows * cols <= 60 -> "$${rows * cols * tenDollars}"
        else -> {
            val hallHalf = rows / 2
            "$${(hallHalf * cols * tenDollars) + (rows - hallHalf) * cols * eightDollars}"
        }
    })
}