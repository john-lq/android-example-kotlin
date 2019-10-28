package com.lqjohn.readjsonfromassetsfolder

import com.google.gson.annotations.SerializedName

class UserModel {
    @SerializedName("name")
    var name: String = ""

    @SerializedName("age")
    var age: Int = 0
}