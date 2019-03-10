package com.lqjohn.floatcontextmenu

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // To open a context menu by clicking on a button
        // You have to register for the button can open the menu
        registerForContextMenu(btnShowContextMenu)

        // Handle event click on the button
        btnShowContextMenu?.setOnClickListener {
            // Open the context menu here
            openContextMenu(it)
            // or
//            openContextMenu(btnShowContextMenu) // Two-case is the same
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_main, menu)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.iItem1 -> {
                showToast("Select item 1")
                return true
            }
            R.id.iItem2 -> {
                showToast("Selected item 2")
                return true
            }
            R.id.iItem3 -> {
                showToast("Selected item 3")
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
