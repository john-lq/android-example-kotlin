package com.lqjohn.readjsonfromassetsfolder

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.lang.Exception
import java.nio.ByteBuffer
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonString = loadJson(this)

        tvJsonString.text = jsonString

        // You can use Gson to parse from json String to json object
        // Add Gson lib
        // Let's create model depends on the json
        // Using Gson to parse json string
        val users = Gson().fromJson(jsonString, ListUserModel::class.java)

        Log.d("MainActivity", "Size: ${users.data.size}")
        // Let's run the app
    }

    /**
     * Write a func to load json from the json_data.json
     */
    private fun loadJson(context: Context): String? {
        var input: InputStream? = null
        var jsonString: String

        try {
            // Create InputStream
            input = context.assets.open("json_data.json")

            val size = input.available()

            // Create a buffer with the size
            val buffer = ByteArray(size)

            // Read data from InputStream into the Buffer
            input.read(buffer)

            // Create a json String
            jsonString = String(buffer)
            return jsonString;
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            // Must close the stream
            input?.close()
        }

        return null
    }
}
