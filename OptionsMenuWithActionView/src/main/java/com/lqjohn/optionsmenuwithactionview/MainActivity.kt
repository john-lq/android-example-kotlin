package com.lqjohn.optionsmenuwithactionview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val actionMenuItem = menu?.findItem(R.id.iSearch)
        actionMenuItem?.setOnActionExpandListener(mCollapseExpandListener)

        // This code means that return a SearchView if actionMenuItem?.actionView is SearchView.
        // Otherwise, return null
        val searchView = actionMenuItem?.actionView as? SearchView
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(text: String?): Boolean {
                // This code means that return a value if text is not null.
                // Otherwise, return an tempty string
                val str = text ?: ""
                showToast("Submit: $str")

                // Collapse SearchView
                actionMenuItem.collapseActionView()

                return true
            }

            override fun onQueryTextChange(text: String?): Boolean {
                // Depends of user cases we should implement method with different cases
                // Note that: this method is also called when the SearchView is collapsed. In this case,
                // the "text" argument is an empty string
                // That's reason why an empty Toast shows when clicking on the Submit
                val str = text ?: ""
                showToast(str)
                return true
            }
        })

        return true
    }

    // Define the listener
    private val mCollapseExpandListener = object : MenuItem.OnActionExpandListener{
        override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
            showToast("Expanded")
            return true
        }

        override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
            showToast("Collapsed")
            return true
        }
    }

    // Define a method to show Toast
    private fun showToast(text: String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
