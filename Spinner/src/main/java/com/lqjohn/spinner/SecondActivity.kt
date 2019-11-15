package com.lqjohn.spinner

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        intent?.let {
            if(it.hasExtra(INTENT_SUM)) {
                val sum = intent.getIntExtra(INTENT_SUM, 0)
                tvSum.text = "Sum: ${sum}"
            }
        }
    }

    companion object {
        private const val INTENT_SUM = "INTENT_SUM"

        fun startActivity(context: Context, sum: Int) {
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra(INTENT_SUM, sum)
            }
            context.startActivity(intent)
        }
    }
}
