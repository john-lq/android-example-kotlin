package com.lqjohn.textviewwithdrawable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This code for using drawable id
//        tvSetDrawableInCode.setCompoundDrawablesWithIntrinsicBounds(
//            R.drawable.ic_camera_alt_black_24dp,
//            R.drawable.ic_camera_alt_black_24dp,
//            R.drawable.ic_camera_alt_black_24dp,
//            R.drawable.ic_camera_alt_black_24dp
//        )

        // This code for using a drawable
        tvSetDrawableInCode.setCompoundDrawablesWithIntrinsicBounds(
            ContextCompat.getDrawable(this, R.drawable.ic_camera_alt_black_24dp),
            ContextCompat.getDrawable(this, R.drawable.ic_username_24dp),
            ContextCompat.getDrawable(this, R.drawable.ic_password_24dp),
            ContextCompat.getDrawable(this, R.drawable.ic_sentiment_very_satisfied_24dp)
        )
    }
}
