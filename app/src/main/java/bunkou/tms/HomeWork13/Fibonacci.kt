package bunkou.tms.HomeWork13

class Fibonacci {
    fun fibCalc(n: Long): Long {
        return when {
            n in 0..1 -> n
            n < 0 -> 0
            else -> fibCalc(n - 1) + fibCalc(n - 2)
        }
    }
}
