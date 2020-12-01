package bunkou.tms

import bunkou.tms.HomeWork13.Fibonacci
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test

class FibonacciTest {
    private lateinit var fibonacci: Fibonacci

    @Before
    fun setUp(){
        fibonacci = Fibonacci()
    }

    @Test
    fun fibonacciCalculate0Number_isTrue(){
        val result = fibonacci.fibCalc(0)
        assertEquals(result, 0)
    }

    @Test
    fun fibonacciCalculate49Number_isTrue(){
        val result = fibonacci.fibCalc(49)
        assertEquals(result, 7778742049)
    }

    @Test
    fun fibonacciCalculate33Number_isTrue(){
        val result = fibonacci.fibCalc(33)
        assertEquals(result, 3524578)
    }

    @Test
    fun fibonacciCalculate15Number_isTrue(){
        val result = fibonacci.fibCalc(15)
        assertEquals(result, 610)
    }
    @Test
    fun fibonacciCalculate17Number_isTrue(){
        val result = fibonacci.fibCalc(17)
        assertEquals(result, 1597)
    }

    @Test
    fun fibonacciCalculateMinus7Number_isTrue(){
        val result = fibonacci.fibCalc(-7)
        assertEquals(result, 0)
    }
    @Test
    fun fibonacciCalculate50Number_isTrue(){
        val result = fibonacci.fibCalc(50)
        assertEquals(result, 12586269025)
    }
}