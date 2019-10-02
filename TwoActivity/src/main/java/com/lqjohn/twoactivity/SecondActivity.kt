package com.lqjohn.twoactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    private var mMessage: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Here, we receive message from FirstActivity
        intent?.let {
            mMessage = it.getStringExtra(FirstActivity.INTENT_MESSAGE)
        }

        // We show the message on the screen
        tvMessage.text = mMessage
    }

    override fun onBackPressed() {
        val intent = Intent().apply {
            putExtra(FirstActivity.INTENT_RETURN_MESSAGE, "$mMessage ____ from SecondActivity")
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
