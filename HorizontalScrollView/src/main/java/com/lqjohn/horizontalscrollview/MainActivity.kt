package com.lqjohn.horizontalscrollview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            // Create a ImageView
            val iv = createImageView()

            // Add the ImageView to LinearLayout(it is a child of HorizontalScrollView)
            lnContent.addView(iv)

            // We need to scroll on the right after adding the new ImageView
            svScrollView.post {
                svScrollView.fullScroll(View.FOCUS_RIGHT)
            }
        }
    }

    private fun createImageView(): ImageView {
        return ImageView(this).apply {
            setImageResource(R.drawable.ic_android)

            // Style for this view
            setPadding(
                    resources.getDimensionPixelSize(R.dimen.default_padding),
                    resources.getDimensionPixelSize(R.dimen.default_padding),
                    resources.getDimensionPixelSize(R.dimen.default_padding),
                    resources.getDimensionPixelSize(R.dimen.default_padding)
            )
        }
    }
}
