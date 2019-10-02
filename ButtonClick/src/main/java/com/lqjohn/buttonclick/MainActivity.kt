package com.lqjohn.buttonclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var mCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCounter.text = mCounter.toString()

        // Handling click button type 2
        btnIncrease.setOnClickListener(this)

        // Handling click button type 3
        btnDecrease.setOnClickListener {
            mCounter--
            tvCounter.text = mCounter.toString()
        }
    }

    // Handling click button type 1
    fun showToast(v: View){
        Toast.makeText(this, "Count: $mCounter", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnIncrease -> {
                mCounter++
                tvCounter.text = mCounter.toString()
            }
        }
    }
}
