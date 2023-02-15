const val tenDollars = 10
const val eightDollars = 8

var purchasedTickets = 0
var currentIncome = 0
var totalIncome = 0

fun main() {

    println("Enter the number of rows:")
    val rows = readln().toInt()

    println("Enter the number of seats in each row:")
    val cols = readln().toInt()

    val seats = rows * cols

    val board = MutableList(rows + 1) {MutableList(cols) {'S'} }

    do {
        println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit")
        val choice = readln().first()

        when(choice) {
            '1' -> {
                print("Cinema:\n ")
                for (i in 1..cols) { print(" $i") }

                println()

                for (i in 1..rows) { print("$i ${board[i].joinToString(" ")}"); println() }
            }

            '2' -> {
                 while (true) {
                     println("Enter a row number:")
                     val ticketRow = readln().toInt()

                     println("Enter a seat number in that row:")
                     val ticketCol = readln().toInt()

                     if (ticketRow > rows || ticketCol > cols) {
                         println("Wrong input!")
                         continue
                     }

                     if (board[ticketRow][ticketCol - 1] == 'B') {
                         println("That ticket has already been purchased!")
                         continue
                     }

                     print("Ticket price: $")
                     currentIncome += when {
                         seats <= 60 -> {
                             println(tenDollars)
                             tenDollars
                         }

                         else -> {
                             println(if (ticketRow <= rows / 2) tenDollars else eightDollars)
                             if (ticketRow <= rows / 2) tenDollars else eightDollars
                         }
                     }

                     board[ticketRow][ticketCol - 1] = 'B'
                     purchasedTickets++
                     break

                 }
            }

            '3' -> {
                val percentage = (purchasedTickets.toDouble() / (rows * cols)) * 100

                totalIncome = if(seats <= 60) seats * tenDollars
                else ((rows / 2) * cols * tenDollars) + ((rows - (rows / 2)) * cols * eightDollars)

                println("""
                Number of purchased tickets: $purchasedTickets
                Percentage: ${"%.2f".format(percentage)}%
                Current income: $${currentIncome}
                Total income: $$totalIncome
            """.trimIndent())
            }
        }

    } while (choice != '0')
}