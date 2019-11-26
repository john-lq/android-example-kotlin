package com.lqjohn.autosizingtextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import androidx.core.widget.TextViewCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TextWatcher {
    override fun afterTextChanged(s: Editable?) {
        tvDefault.text = "Default ${etTypeSomthing.text}"
        tvGranularity.text = "Granularity ${etTypeSomthing.text}"
        tvPresetSizes.text = "Preset size ${etTypeSomthing.text}"
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        // Do nothing
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        // Do nothing
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Using kotlin
        // Default mode
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(tvDefault,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)

        // Granularity mode
//        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
//            tvGranularity,
//            8,
//            50,
//            2,
//            TypedValue.COMPLEX_UNIT_SP
//        )

        // Preset sizes
        TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(
            tvPresetSizes,
            intArrayOf(8, 16, 24, 40, 50),
            TypedValue.COMPLEX_UNIT_SP
        )

        etTypeSomthing.addTextChangedListener(this)
    }
}
