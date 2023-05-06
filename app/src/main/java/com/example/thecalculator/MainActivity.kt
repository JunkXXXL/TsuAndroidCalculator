package com.example.thecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.thecalculator.databinding.ActivityMainBinding
import kotlinx.coroutines.processNextEventInCurrentThread
import java.util.Stack

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var line: String = ""
    private val poliz: Stack<String> = Stack<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        binding.button0.setOnClickListener{
            line += "0"
            binding.mathExpression.setText(line)
        }
        binding.button1.setOnClickListener{
            line += "1"
            binding.mathExpression.setText(line)
        }
        binding.button2.setOnClickListener{
            line += "2"
            binding.mathExpression.setText(line)
        }
        binding.button3.setOnClickListener{
            line += "3"
            binding.mathExpression.setText(line)
        }
        binding.button4.setOnClickListener{
            line += "4"
            binding.mathExpression.setText(line)
        }
        binding.button5.setOnClickListener{
            line += "5"
            binding.mathExpression.setText(line)
        }
        binding.button6.setOnClickListener{
            line += "6"
            binding.mathExpression.setText(line)
        }
        binding.button7.setOnClickListener{
            line += "7"
            binding.mathExpression.setText(line)
        }
        binding.button8.setOnClickListener{
            line += "8"
            binding.mathExpression.setText(line)
        }
        binding.button9.setOnClickListener{
            line += "9"
            binding.mathExpression.setText(line)
        }
        binding.buttonPlus.setOnClickListener{
            line += " + "
            binding.mathExpression.setText(line)
        }
        binding.buttonMinus.setOnClickListener{
            line += " - "
            binding.mathExpression.setText(line)
        }
        binding.buttonMultiplication.setOnClickListener{
            line += " * "
            binding.mathExpression.setText(line)
        }
        binding.buttonDivision.setOnClickListener{
            line += " / "
            binding.mathExpression.setText(line)
        }
        binding.buttonPercent.setOnClickListener{
            line += " % "
            binding.mathExpression.setText(line)
        }
        binding.buttonPlusminus.setOnClickListener{
            line += " * -1 "
            binding.mathExpression.setText(line)
        }
        binding.buttonDot.setOnClickListener{
            line += "."
            binding.mathExpression.setText(line)
        }
        binding.buttonAC.setOnClickListener{
            line = ""
            binding.mathExpression.setText(line)
            drop_poliz(poliz)
        }
        binding.buttonEquation.setOnClickListener{
            val answer: String = equation(root, line, poliz)
            binding.solutionView.setText(answer)
        }

    }
}