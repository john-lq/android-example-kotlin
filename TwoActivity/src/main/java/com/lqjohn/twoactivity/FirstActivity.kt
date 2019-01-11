package com.lqjohn.twoactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Check result code and request code
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_START_SECOND_ACTIVITY){
            data?.let {
                val result = it.getStringExtra(INTENT_RETURN_MESSAGE)

                // Showing the result on the FirstActivity
                tvResultMessage.text = result
            }
        }
    }

    /**
     * Handle event click on the [btnSend]
     * Clicking on button to open the Second Activity
     */
    public fun sendMessage(v: View) {
        // And now, we send mMessage from FirstActivity to SecondActivity
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra(INTENT_MESSAGE, etMessage.text.toString())
        }
        // To receive a result from an activity. We have to use startActivityForResult method
        // And we need a request code
        // And override onActivityResult method to receive a result
        startActivityForResult(intent, REQUEST_CODE_START_SECOND_ACTIVITY)
    }

    companion object {
        const val INTENT_MESSAGE = "INTENT_MESSAGE"
        const val INTENT_RETURN_MESSAGE = "INTENT_RETURN_MESSAGE"
        const val REQUEST_CODE_START_SECOND_ACTIVITY = 1234
    }
}
