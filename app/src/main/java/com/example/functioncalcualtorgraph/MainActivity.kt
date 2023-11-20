package com.example.functioncalcualtorgraph

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.Expression





class MainActivity : AppCompatActivity() {
    private lateinit var inputEditText: EditText
    private lateinit var evaluateButton: Button
    private lateinit var resultTextView: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputEditText = findViewById<EditText>(R.id.inputEditText)
        evaluateButton = findViewById<Button>(R.id.evaluateButton)
        resultTextView = findViewById<TextView>(R.id.resultTextView)
        evaluateButton.setOnClickListener {
            evaluateExpression();
        }



    }

    private fun evaluateExpression() {
        val expressionString = inputEditText.text.toString().trim { it <= ' ' }
        if (!expressionString.isEmpty()) {
            val e = Expression(expressionString)
            //val expression = Expresion(expressionString)
            val result: Double = e.calculate()
            resultTextView.text = "Result: $result"
        } else {
            resultTextView.text = "Enter a valid expression."
        }
    }
}