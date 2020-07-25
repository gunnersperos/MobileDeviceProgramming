package mobile.programming.musicapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mobile.programming.musicapp.dto.Instrument
import mobile.programming.musicapp.service.InstrumentService

class MainViewModel: ViewModel() {

    var instruments: MutableLiveData<ArrayList<Instrument>> = MutableLiveData<ArrayList<Instrument>>()
    private var instrumentService: InstrumentService =
        InstrumentService()

    internal fun getAllInstruments(){
        instruments = instrumentService.fetchInstruments()
    }
}