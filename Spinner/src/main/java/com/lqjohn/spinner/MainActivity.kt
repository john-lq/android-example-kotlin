package com.lqjohn.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNumberAdapter = ArrayAdapter<Int>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            createNumberList()
        )

        val secondNumberAdapter = ArrayAdapter<Int>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            createNumberList()
        )

        snFirstNumber.adapter = firstNumberAdapter
        snSecondNumber.adapter = secondNumberAdapter

        btnSum.setOnClickListener {
            // This code(as?) will convert `snFirstNumber.selectedItem` to Int value if it is not null
            // If it is null then the `firstNumber` will be set null

            // `?:` if the left side is null then setting the `firstNumber` is 0
            // else setting the `firstNumber with the value of the left side`
            val firstNumber = (snFirstNumber.selectedItem as? Int) ?: 0
            val secondNumber = (snSecondNumber.selectedItem as? Int) ?: 0

            Toast.makeText(this, "Sum: ${firstNumber + secondNumber}", Toast.LENGTH_SHORT).show()
        }

        btnSumAndSendToAnotherScreen.setOnClickListener {
            // This code(as?) will convert `snFirstNumber.selectedItem` to Int value if it is not null
            // If it is null then the `firstNumber` will be set null

            // `?:` if the left side is null then setting the `firstNumber` is 0
            // else setting the `firstNumber with the value of the left side`
            val firstNumber = (snFirstNumber.selectedItem as? Int) ?: 0
            val secondNumber = (snSecondNumber.selectedItem as? Int) ?: 0

            SecondActivity.startActivity(this, (firstNumber + secondNumber))
        }
    }

    private fun createNumberList(): List<Int> {
        val list = ArrayList<Int>()
        for (i in 0 until 20) {
            list.add(i)
        }
        return list;
    }
}
