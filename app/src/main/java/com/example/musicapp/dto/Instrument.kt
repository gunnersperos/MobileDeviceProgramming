package com.example.musicapp.dto

data class Instrument(var id: Int, var name: String, var type: String) {
    //Represents an instrument
    override fun toString(): String {
        return name
    }
}