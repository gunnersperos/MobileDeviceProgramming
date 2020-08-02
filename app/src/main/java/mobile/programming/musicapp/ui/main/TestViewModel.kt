package mobile.programming.musicapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mobile.programming.musicapp.dto.Instrument
import mobile.programming.musicapp.service.InstrumentService


//This is a copy of MainViewModel without firebase so tests will function
class TestViewModel: ViewModel() {

    var instruments: MutableLiveData<ArrayList<Instrument>> = MutableLiveData<ArrayList<Instrument>>()
    var instrumentService: InstrumentService =
        InstrumentService()

    internal fun getAllInstruments(){
        instruments = instrumentService.fetchInstruments()

    }


}