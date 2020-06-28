package com.example.musicapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicapp.dto.Instrument
import com.example.musicapp.service.InstrumentService

class MainViewModel: ViewModel() {

    var instruments: MutableLiveData<ArrayList<Instrument>> = MutableLiveData<ArrayList<Instrument>>()
    var instrumentService: InstrumentService = InstrumentService()

    fun getAllInstruments(){
        instruments = instrumentService.fetchInstruments()

    }
}