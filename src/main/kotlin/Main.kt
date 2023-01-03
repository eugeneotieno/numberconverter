fun main() {
    var exit = false
    do {
        print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ")
        when(readln()) {
            "/from" -> {
                print("Enter a number in decimal system: ")
                val num = readln().toInt()
                print("Enter the target base: ")
                val target = readln().toInt()
                convertFromDecimal(num, target)
            }
            "/to" -> {
                print("Enter source number: ")
                val num = readln()
                print("Enter source base: ")
                val target = readln().toInt()
                convertToDecimal(num, target)
            }
            "/exit" -> {
                exit = true
            }
        }
    } while (!exit)
}

fun convertFromDecimal(num: Int, target: Int) {
    var result = ""
    when(target) {
        2 -> {
            result = Integer.toBinaryString(num)
        }
        8 -> {
            result = Integer.toOctalString(num)
        }
        16 -> {
            result = Integer.toHexString(num)
        }
    }

    println("Conversion result: $result")
    println()
}

fun convertToDecimal(num: String, target: Int) {
    println("Conversion to decimal result: ${num.toInt(radix = target)}")
    println()
}