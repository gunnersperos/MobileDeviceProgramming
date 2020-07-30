package mobile.programming.musicapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import mobile.programming.musicapp.dto.Instrument
import mobile.programming.musicapp.service.InstrumentService

class MainViewModel: ViewModel() {

    var instruments: MutableLiveData<ArrayList<Instrument>> = MutableLiveData<ArrayList<Instrument>>()
    var instrumentService: InstrumentService =
        InstrumentService()
    private lateinit var  firestore: FirebaseFirestore

    init{
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    internal fun getAllInstruments(){
        instruments = instrumentService.fetchInstruments()

    }

    fun saveToFirestore(arrayList: ArrayList<String>){
        firestore.collection("users")
    }
}