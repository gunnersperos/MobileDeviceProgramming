package mobile.programming.musicapp.ui.main

import android.util.Log
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
    private var firestore: FirebaseFirestore

    init{
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    internal fun getAllInstruments(){
        instruments = instrumentService.fetchInstruments()

    }

    fun saveToFirestore(unlockedInstrumentsList: ArrayList<String>,userID: String){

        val userData = hashMapOf(
            "unlockedInstruments" to unlockedInstrumentsList
        )

        firestore.collection("users").document(userID)
            .set(userData)
            .addOnSuccessListener { Log.d("firestore", "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w("firestore", "Error writing document", e) }

    }

    fun LoadFromFirestore(userID: String){
        val instrumentRef = firestore.collection("users").document(userID)
        instrumentRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("firestore load", "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d("firestore load", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("firestore load", "get failed with ", exception)
            }

    }
}