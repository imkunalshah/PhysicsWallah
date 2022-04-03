package com.kunal.physicswallah.data.network.models

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val name:String,
    @SerializedName("subjects")
    val subjects:List<String>,
    @SerializedName("qualification")
    val qualification:List<String>,
    @SerializedName("profileImage")
    val profileImage:String
)