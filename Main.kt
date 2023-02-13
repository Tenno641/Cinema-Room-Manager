const val tenDollars = 10
const val eightDollars = 8

fun main() {

    println("Enter the number of rows:")
    val rows = readln().toInt()

    println("Enter the number of seats in each row:")
    val cols = readln().toInt()

    val board = MutableList(rows + 1) {MutableList(cols) {'S'} }

    do {
        println("1. Show the seats\n2. Buy a ticket\n0. Exit")
        val choice = readln().first()

        when(choice) {
            '1' -> {
                print("Cinema:\n ")
                for (i in 1..cols) { print(" $i") }

                println()

                for (i in 1..rows) { print("$i ${board[i].joinToString(" ")}"); println() }
            }

            '2' -> {
                println("Enter a row number:")
                val ticketRow = readln().toInt()

                println("Enter a seat number in that row:")
                val ticketCol = readln().toInt()

                print("Ticket price: $")
                println(when {
                    rows * cols <= 60 -> tenDollars
                    else -> {
                        if(ticketRow <= rows / 2) tenDollars else eightDollars
                    }
                })

                board[ticketRow][ticketCol - 1] = 'B'

            }
        }
    } while (choice != '0')
}