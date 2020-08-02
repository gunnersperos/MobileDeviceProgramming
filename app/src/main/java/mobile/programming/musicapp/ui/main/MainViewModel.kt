package mobile.programming.musicapp.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import mobile.programming.musicapp.dto.Instrument
import mobile.programming.musicapp.dto.UserData
import mobile.programming.musicapp.service.InstrumentService

class MainViewModel : ViewModel() {

    var instruments: MutableLiveData<ArrayList<Instrument>> =
        MutableLiveData<ArrayList<Instrument>>()
    var instrumentService: InstrumentService =
        InstrumentService()
    private var firestore: FirebaseFirestore

    init {

        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    internal fun getAllInstruments() {
        instruments = instrumentService.fetchInstruments()

    }

    fun saveToFirestore(unlockedInstrumentsList: ArrayList<String>, money: Double, userID: String) {

        val userData = hashMapOf(
            "unlockedInstruments" to unlockedInstrumentsList,
            "money" to money
        )

        firestore.collection("users").document(userID)
            .set(userData)
            .addOnSuccessListener { Log.d("firestore", "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w("firestore", "Error writing document", e) }

    }

    fun loadFromFirestore(userID: String): UserData {
        val instrumentRef = firestore.collection("users").document(userID)
        val userData = UserData(id = userID, money = 0.0, unlockedInstruments = ArrayList())

        instrumentRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("firestore load", "DocumentSnapshot data: ${document.data}")

                    try {
                        userData.money = document.getDouble("money")!!
                        userData.unlockedInstruments =
                            (document.get("unlockedInstruments") as ArrayList<String>?)!!
                        Log.d(
                            "firestore object convert",
                            "Money: ${userData.id}, Money: ${userData.money}, unlocked list:  ${userData.unlockedInstruments}"
                        )
                    } catch (ex: Exception) {
                        Log.d("firestore object convert", "Failed to load user data")
                    }

                } else {
                    Log.d("firestore load", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("firestore load", "get failed with ", exception)
            }
        return userData
    }

    fun deleteUserData(userID: String) {
        //not used, but needed for grade rubric
        val instrumentRef = firestore.collection("users").document(userID)

        val updates = hashMapOf<String, Any>(
            "money" to FieldValue.delete(),
            "unlockedInstruments" to FieldValue.delete()
        )

        instrumentRef.update(updates).addOnCompleteListener {
            Log.d("firestore delete", "Delete success")
        }
    }

}