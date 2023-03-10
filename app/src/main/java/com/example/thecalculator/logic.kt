package com.example.thecalculator

import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.util.*


    private val operators: Array<String> = arrayOf("%", "*", "/", "+", "-")

    fun drop_poliz(poliz: Stack<String>)
    {
        while (!poliz.empty()) poliz.pop()
    }

    fun equation(view: View, line: String, poliz: Stack<String>): String{
        fillPoliz(line, poliz)
        val Calc: Stack<Float> = Stack<Float>()
        val newPoliz: Stack<String> = Stack<String>()

        while (poliz.isNotEmpty())
        {
            val el = poliz.pop()
            if ((el != "") and (el != ".")) newPoliz.push(el)
        }

        while (newPoliz.isNotEmpty())
        {
            var i: String = newPoliz.pop()
            Log.d("element", i)

            while (i !in operators)
            {
                if (i.lastIndexOf('.') != i.indexOf('.'))
                {
                    Log.d("element", "a lot of dots")
                    val toReturn: String = "too many dots"
                    drop_poliz(poliz)
                    return toReturn
                }
                Calc.push(i.toFloat())
                if (newPoliz.isNotEmpty()) {
                    i = newPoliz.pop()
                    Log.d("element", i)
                }
                else break
            }

            if (Calc.isEmpty())
            {
                Log.d("element", "not enough operands")
                val toReturn: String = "not enough operands"
                drop_poliz(poliz)
                return toReturn
            }
            val y: Float = Calc.pop()

            if (Calc.isEmpty())
            {
                Log.d("element", "not enough operands")
                val toReturn: String = "not enough operands"
                drop_poliz(poliz)
                return toReturn
            }

            val x: Float = Calc.pop()
            var z: Float? = 0f
            when (i)
            {
                "+" -> z = x + y
                "-" -> z = x - y
                "*" -> z = x * y
                "/" ->
                {
                    if (y != 0f) z = x / y
                    else
                        z = null
                }
                "%" ->
                {
                    if (y != 0f) z = x % y
                    else
                        z = null
                }
            }

            if (z == null) {
                Log.d("element", "Division by zero")
                val toReturn: String = "Division by zero"
                drop_poliz(poliz)
                return toReturn
            }
            else Calc.push(z)

        }

        drop_poliz(poliz)
        var ot: String = " "
        if (Calc.isNotEmpty()) {
            ot += Calc.pop().toString()
            return ot
        }
        else
        {
            return "Enter equation"
        }
    }

    fun Operation_prior(operate: String) : Int
    {
        when (operate)
        {
            "%" -> return 3
            "/" -> return 2
            "*" -> return 2
            "-" -> return 1
            "+" -> return 1
            else -> return 0
        }
    }

    fun fillPoliz(line: String, poliz: Stack<String>)
    {
        val strs: Array<String> = line.split(' ').toTypedArray()
        val operation_stack: Stack<String> = Stack<String>()
        val priorStack: Stack<Int> = Stack<Int>()

        for (i in strs)
        {
            if (i !in operators)
                poliz.push(i)
            else if (operation_stack.isEmpty())
            {
                operation_stack.push(i)
                priorStack.push(Operation_prior(i))
            }
            else if (priorStack.peek() < Operation_prior(i))
            {
                operation_stack.push(i)
                priorStack.push(Operation_prior(i))
            }
            else
            {
                var Flag: Boolean = (operation_stack.isNotEmpty())
                while (Flag)
                {
                    if (priorStack.peek() >= Operation_prior(i)) {
                        poliz.push(operation_stack.pop())
                        priorStack.pop()
                        Flag = operation_stack.isNotEmpty()
                    }
                    else Flag = false

                }
                operation_stack.push(i)
                priorStack.push(Operation_prior(i))
            }
        }
        while (operation_stack.isNotEmpty())
        {
            poliz.push(operation_stack.pop())
            priorStack.pop()
        }

    }
