package com.lqjohn.spinnercustomitem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = CustomAdapter(this, createUserModelList())
        spUser.adapter = adapter
    }

    private fun createUserModelList(): ArrayList<UserModel> {
        val list = ArrayList<UserModel>()

        for (i in 0 until 20) {
            list.add(UserModel(i.toLong(), "Name $i"))
        }

        return list
    }
}
