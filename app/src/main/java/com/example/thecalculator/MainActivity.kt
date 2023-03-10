package com.example.thecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.processNextEventInCurrentThread
import java.util.Stack

class MainActivity : AppCompatActivity() {
    private var line: String = ""
    private val poliz: Stack<String> = Stack<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Drop(view: View)
    {
        drop_poliz(poliz)

        line = " "
        val txt: TextView = findViewById(R.id.Text_output)
        txt.text = (" ")
        val ln: TextView = findViewById(R.id.math_expression)
        ln.text = " "
    }

    fun operator_eq(view: View)
    {
        val solutionView: TextView = findViewById(R.id.Text_output)
        solutionView.text = equation(view, line, poliz)
    }

    fun operator_division(view: View)
    {
        line += " / "
        val ln: TextView = findViewById(R.id.math_expression)
        ln.text = line
    }

    fun operator_plus(view: View)
    {
        line += " + "
        val ln: TextView = findViewById(R.id.math_expression)
        ln.text = line
    }

    fun operator_multiplicate(view: View)
    {
        line += " * "
        val ln: TextView = findViewById(R.id.math_expression)
        ln.text = line
    }

    fun operator_minus(view: View)
    {
        line += " - "
        val ln: TextView = findViewById(R.id.math_expression)
        ln.text = line
    }

    fun operator_percent(view: View)
    {
        line += " % "
        val ln: TextView = findViewById(R.id.math_expression)
        ln.text = line
    }

    fun operator_plusminus(view: View)
    {
        line += " * -1"
        val ln: TextView = findViewById(R.id.math_expression)
        ln.text = line
    }

    fun operator_dot(view: View)
    {
        line += "."
        val ln: TextView = findViewById(R.id.math_expression)
        ln.text = line
    }

    fun Add_Number_0(view: View)
    {
            line += "0"
            val txt: TextView = findViewById<TextView>(R.id.math_expression)
            txt.text = (line)
    }

    fun Add_Number_1(view: View)
    {
            line += "1"
            val txt: TextView = findViewById<TextView>(R.id.math_expression)
            txt.text = (line)
    }

    fun Add_Number_2(view: View)
    {
            line += "2"
            val txt: TextView = findViewById<TextView>(R.id.math_expression)
            txt.text = (line)
    }

    fun Add_Number_3(view: View)
    {
            line += "3"
            val txt: TextView = findViewById<TextView>(R.id.math_expression)
            txt.text = (line)
    }

    fun Add_Number_4(view: View)
    {
            line += "4"
            val txt: TextView = findViewById<TextView>(R.id.math_expression)
            txt.text = (line)
    }

    fun Add_Number_5(view: View)
    {
            line += "5"
            val txt: TextView = findViewById<TextView>(R.id.math_expression)
            txt.text = (line)
    }

    fun Add_Number_6(view: View)
    {
            line += "6"
            val txt: TextView = findViewById<TextView>(R.id.math_expression)
            txt.text = (line)
    }

    fun Add_Number_7(view: View)
    {
            line += "7"
            val txt: TextView = findViewById<TextView>(R.id.math_expression)
            txt.text = (line)
    }

    fun Add_Number_8(view: View)
    {
            line += "8"
            val txt: TextView = findViewById<TextView>(R.id.math_expression)
            txt.text = (line)
    }

    fun Add_Number_9(view: View)
    {
            line += "9"
            val txt: TextView = findViewById<TextView>(R.id.math_expression)
            txt.text = (line)
    }

    fun String_delete(view: View)
    {
        line = line.dropLast(1)
        line = line.dropLastWhile { it == ' ' }
        val txt: TextView = findViewById<TextView>(R.id.math_expression)
        txt.text = (line)
    }
}