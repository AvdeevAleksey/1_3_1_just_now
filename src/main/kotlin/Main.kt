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
                in 11..19 -> "минут"
            else -> when (time / t % 10) {
                1 -> "минуту"
                in 2..4 -> "минуты"
                else -> "минут"
                }
            }
        }
        else -> {
            when (time / t * t) {
                in 11..19 -> "часов"
                else -> when (time / (t * t) % 10) {
                    1 -> "час"
                    in 2..4 -> "часа"
                    else -> "часов"
                }
            }
        }
    }
}