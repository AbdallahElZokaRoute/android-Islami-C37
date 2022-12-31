package com.route.islamic37.lambdaExpression

import android.util.Log

class Main {

    //Lambda Expression
    /*
        is An Alternative way to declare Function


     */

    val printValue: (Int) -> Unit = {
        Log.e("TAG", "doAddition:$it ")
    }

    fun doAddition() {
        val result = addTwoNumbers(5, 6)
        val result2 = add(10, 20, printValue)
    }

    val addTwoNumbers: (number1: Int, number2: Int) -> Int = { number1, number2 ->

        number1 + number2

    }

    //Unit = void in java
    fun add(number1: Int, number2: Int, doSomething: (Int) -> Unit): Int {
        val result = number1 + number2
        doSomething(result)
        return result
    }
}


fun addTwoNumbers2(number1: Int, number2: Int): Int {
    return number1 + number2
}



