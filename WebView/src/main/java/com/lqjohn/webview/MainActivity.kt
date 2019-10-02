package com.lqjohn.webview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wvWebView?.let {
            it.settings.javaScriptEnabled = true
            it.loadUrl(URL)
        }
    }

    companion object {
        private const val URL = "https://www.youtube.com/channel/UCXAZFMMGi5_C6lbW2qDsnZw"
    }
}
