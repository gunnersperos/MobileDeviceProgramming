package com.example.musicapp.service

import androidx.lifecycle.MutableLiveData
import com.example.musicapp.RetrofitClientInstance
import com.example.musicapp.dao.MusicAppDAO
import com.example.musicapp.dto.Instrument
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log

class InstrumentService {

    fun fetchInstruments(): MutableLiveData<ArrayList<Instrument>>{
        val instruments = MutableLiveData<ArrayList<Instrument>>()
        val service = RetrofitClientInstance.retrofitInstance?.create(MusicAppDAO::class.java)
        val call = service?.getAllInstruments()
        call?.enqueue(object: Callback<ArrayList<Instrument>>{

            override fun onFailure(call: Call<ArrayList<Instrument>>, t: Throwable) {
                val j = 1 + 1
                val i = 1 + 1

            }

            override fun onResponse(
                call: Call<ArrayList<Instrument>>,
                response: Response<ArrayList<Instrument>>
            ) {
            instruments.value = response.body()
                print("hi")
                print(response.body())
            }

        })

        return instruments
    }

}