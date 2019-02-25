package com.lqjohn.optionsmenuwithactionprovider

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.ShareActionProvider
import android.view.Menu

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        // Get a reference to the ShareActionProvider
        val menuItem = menu?.findItem(R.id.iShare)
        val shareProvider = MenuItemCompat.getActionProvider(menuItem) as ShareActionProvider

        // Create an intent for sharing an image
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            type = "image/*"
            putExtra(Intent.EXTRA_STREAM, Uri.parse("Image_url"))
        }

        // Set the intent into the ShareActionProvider
        shareProvider.setShareIntent(intent)

        return true
    }
}
