package com.example.functioncalcualtorgraph

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.Expression
import org.mariuszgromada.math.mxparser.Function





class MainActivity : AppCompatActivity() {
    private lateinit var inputEditText: EditText
    private lateinit var inputEditTextA: EditText
    private lateinit var inputEditTextB: EditText
    private lateinit var evaluateButton: Button
    private lateinit var resultTextView1: TextView
    private lateinit var resultTextView2: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputEditText = findViewById<EditText>(R.id.inputEditText)
        inputEditTextA = findViewById<EditText>(R.id.inputEditTextA)
        inputEditTextB = findViewById<EditText>(R.id.inputEditTextB)
        evaluateButton = findViewById<Button>(R.id.evaluateButton)
        resultTextView1 = findViewById<TextView>(R.id.resultTextViewa)
        resultTextView2 = findViewById<TextView>(R.id.resultTextViewb)



        evaluateButton.setOnClickListener {
            var a:Double = inputEditTextA.text.toString().toDouble()
            var b:Double = inputEditTextB.text.toString().toDouble()
            val expressionString = inputEditText.text.toString().trim { it <= ' ' }
            evaluateExpression(a,b,expressionString);
        }



    }

    private fun evaluateExpression(a: Double, b: Double, e: String) {


        val f = Function("f", e, "x")

        if (!e.isEmpty()) {
            val e1 = Expression("f($a)",f)
            val e2 = Expression("f($b)",f)
            //val expression = Expresion(expressionString)
            val resulta: Double = e1.calculate()
            resultTextView1.text = "Resultado a: $resulta"
            val resultb: Double = e2.calculate()
            resultTextView2.text = "Resultado b: $resultb"
        } else {
            resultTextView1.text = "Enter a valid expression."
        }
    }
}