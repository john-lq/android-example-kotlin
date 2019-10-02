package com.lqjohn.buttonbackground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Update the button when starting this activity
        setButtonEnable(!cbDisable.isChecked)

        cbDisable.setOnCheckedChangeListener { _, isChecked ->
            // Update the button when checking/un-checking the CheckBox
            setButtonEnable(!isChecked)
        }
    }

    private fun setButtonEnable(isEnable: Boolean) {
        btnEnableDisable.isEnabled = isEnable
    }
}
