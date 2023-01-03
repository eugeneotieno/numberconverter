fun main() {
    print("Enter number in decimal system: ")
    val num = readln().toInt()
    print("Enter target base: ")
    when(readln().toInt()) {
        2 -> {
            println("Conversion result: ${Integer.toBinaryString(num)}")
        }
        8 -> {
            println("Conversion result: ${Integer.toOctalString(num)}")
        }
        16 -> {
            println("Conversion result: ${Integer.toHexString(num)}")
        }
    }
}

fun convertByBase(num: Int, target: Int) {
    var converted = ""
    if (num == 0) converted += "0"

    var n = num
    while (n > 0) {
        converted += "${n % target}"
        n /= target
    }

    println("Conversion result: ${converted.reversed()}")
}