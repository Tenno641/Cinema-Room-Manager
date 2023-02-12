fun cinemaHall(rows: Int, cols: Int, ticketR: Int = 0, ticketC: Int = 0) {
    println("Cinema:")
    print(" ")
    for (i in 1..cols) {
        print(" $i")
    }
    println()
    for (i in 1..rows) {
        print("$i")
        for (j in 1..cols) {
            when {
                i == ticketR && j == ticketC -> print(" B")
                else -> print(" S")
            }
        }
        println()
    }
}

const val tenDollars = 10
const val eightDollars = 8

fun main() {

    println("Enter the number of rows:")
    val rows = readln().toInt()

    println("Enter the number of seats in each row:")
    val cols = readln().toInt()

    cinemaHall(rows, cols)

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
    cinemaHall(rows, cols, ticketRow, ticketCol)
}