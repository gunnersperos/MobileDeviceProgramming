package com.example.musicapp.dao

import com.example.musicapp.dto.Instrument
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicAppDAO {
    //https://jsonkeeper.com/b/JIH2
    //json to be updated in the future with planned instruments
    @GET("/b/JIH2")

    fun getAllInstruments(): Call<ArrayList<Instrument>>
}