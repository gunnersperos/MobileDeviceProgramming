package com.example.musicapp.dto

import com.google.gson.annotations.SerializedName

data class Instrument(
    @SerializedName("id")var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("name") var type: String
){
    //Represents an instrument
    override fun toString(): String {
        return name
    }
}