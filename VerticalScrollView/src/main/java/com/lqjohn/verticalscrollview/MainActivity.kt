package com.lqjohn.verticalscrollview

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            // Create a TextView with the text which is get from EditText(etMessage)
            val tv = createTextView(etMessage.text.toString())

            // Add the TextView to LinearLayout(it is a child of ScrollView)
            lnContent.addView(tv)

            // We need to scroll to the bottom after adding the new view
            svScrollView.post {
                svScrollView.fullScroll(View.FOCUS_DOWN)
            }
        }
    }

    /**
     * We create a TextView with the text which is get from EditText(etMessage)
     */
    private fun createTextView(message: String): TextView {
        return TextView(this).apply {
            text = message

            // We need to style for the new TextView
            // Set the text size for the TextView. The first argument is unit(SP). The second argument is value
            // -> set 16sp for the text size
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)

            // Set the text color is black
            setTextColor(Color.BLACK)

            // Set the padding values for the top, right, bottom, and left
            setPadding(
                    resources.getDimensionPixelSize(R.dimen.default_padding),
                    resources.getDimensionPixelSize(R.dimen.default_padding),
                    resources.getDimensionPixelSize(R.dimen.default_padding),
                    resources.getDimensionPixelSize(R.dimen.default_padding)
            )
        }
    }
}
