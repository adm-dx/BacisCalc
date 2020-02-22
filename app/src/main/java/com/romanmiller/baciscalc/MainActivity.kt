package com.romanmiller.baciscalc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun calc(operation: String) {
            val argument1 = arg1.text.toString()
            val argument2 = arg2.text.toString()
            try {
                val x = argument1.toInt()
                val y = argument2.toInt()
                when (operation) {
                    "add" -> answer.setText((x + y).toString())
                    "subtr" -> answer.setText((x - y).toString())
                    "mul" -> answer.setText((x * y).toString())
                    "divide" -> {
                        if (y != 0) answer.setText((x.toDouble() / y).toString())
                        else answer.setText(R.string.div_by_zero_error)
                    }
                }
            } catch (e: NumberFormatException) {
                answer.setText(R.string.input_error)
            }
        }

        add.setOnClickListener {
            calc("add")
        }
        subtr.setOnClickListener {
            calc("subtr")
        }
        mul.setOnClickListener {
            calc("mul")
        }
        divide.setOnClickListener {
            calc("divide")
        }
    }
}
