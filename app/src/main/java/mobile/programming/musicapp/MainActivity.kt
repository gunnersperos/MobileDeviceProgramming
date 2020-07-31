package mobile.programming.musicapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import mobile.programming.musicapp.ui.main.MainViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var mvm: MainViewModel
        lateinit var userID: String

        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {

                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token

                Log.d("token", token.toString())
                Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
                userID = token.toString()

                //sample code for saving to firestore DB
                mvm = MainViewModel()
                val list = arrayListOf("piano", "guitar", "drums")
                mvm.saveToFirestore(list, userID)
                mvm.LoadFromFirestore(userID)
                //TODO update main UI buttons to reveal unlocked instruments on load



            })






    }
}


