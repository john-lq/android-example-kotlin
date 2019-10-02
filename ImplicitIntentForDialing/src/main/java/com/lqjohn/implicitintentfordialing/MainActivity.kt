package com.lqjohn.implicitintentfordialing

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Handle event click on the btnCall button
        btnCall.setOnClickListener {
            // Get the input phone number from EditText
            val phoneNumber = etPhoneNumber.text

            // But we have to create a Intent first
            val intent = Intent(Intent.ACTION_DIAL).apply {
                // Pass the phone number to the Intent
                data = Uri.parse("tel:$phoneNumber")
            }

            // To avoid exception, before starting an implicit intent
            // use the package manager to check that
            // there is an package with an an activity
            // that matches the give criteria
            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
        }
    }
}
