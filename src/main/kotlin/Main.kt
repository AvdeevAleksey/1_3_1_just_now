fun main() {
    print("Введите время в секундах: ")
    val time:Int = readLine()!!.toInt()
    println("был(а) в сети ${agoToText(time)}")
}

fun agoToText(time: Int,t:Int = 60): String {
    return when (time) {
        in 0..t -> "только что"
        in t+1 until t*t -> "${time/t} ${agoStringText(time)} назад"
        in t*t..24*t*t -> "${time/(t*t)} ${agoStringText(time)} назад"
        in t*t*24..t*t*48 -> "сегодня"
        in t*t*48..t*t*72 -> "вчера"
        else -> "давно"
    }
}

fun agoStringText(time: Int, t:Int = 60): String {
    return when (time) {
        in t + 1 until t * t -> {
            when (time / t) {
                1, 21, 31, 41, 51 -> "минуту"
                2, 22, 32, 42, 52 -> "минуты"
                else -> "минут"
            }
        }
        else -> {
            when (time / (t * t)) {
                1, 21, 31, 41, 51 -> "час"
                2, 22, 32, 42, 52 -> "часа"
                else -> "часов"
                }
            }
        }
    }