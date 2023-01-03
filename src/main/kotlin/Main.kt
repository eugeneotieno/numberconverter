import java.math.BigInteger

fun main() {
    start()
}

fun start() {
    var exit = false
    do {
        print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ")
        val action = readln()
        if (action == "/exit") {
            exit = true
        } else {
            val source = action.split(" ")[0]
            val target = action.split(" ")[1]

            var sameSource = true
            while (sameSource) {
                print("Enter number in base $source to convert to base $target (To go back type /back) ")
                val num = readln()

                if (num == "/back") {
                    sameSource = false
                    println()
                } else {
                    if (source == "10") {
                        convertFromDecimal(num.toBigInteger(), target)
                    } else if (target == "10") {
                        convertToDecimal(num, source.toInt())
                    } else {
                        val numDecimal = num.toBigInteger(source.toInt())
                        val rs = numDecimal.toString(target.toInt())
                        println("Conversion result: $rs")
                        println()
                    }
                }
            }
        }
    } while (!exit)
}

fun convertToDecimal(num: String, target: Int) {
    println("Conversion result: ${num.toInt(radix = target)}")
    println()
}

fun convertFromDecimal(num: BigInteger, target: String) {
    var holder = ""
    var n = num
    while (n > BigInteger.ZERO) {
        holder += "${n % BigInteger.valueOf(target.toLong())}"
        n /= BigInteger.valueOf(target.toLong())
    }

    println("Conversion result: ${holder.reversed()}")
    println()
}