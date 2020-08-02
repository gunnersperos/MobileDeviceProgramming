package mobile.programming.musicapp

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import mobile.programming.musicapp.dto.UserData
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
                userID = token.toString()

                //sample code for saving, getting, or deleting user data in firestore DB
                mvm = MainViewModel()
                val list = arrayListOf("piano", "guitar", "drums")
                val money = 50.5
                mvm.saveToFirestore(list,money,userID)
                var userData: UserData? = mvm.loadFromFirestore(userID)
                //TODO update main UI buttons to enable unlocked instruments on load
            })

        // go to store screen
        val button = findViewById<Button>(R.id.btnStore)
        button.setOnClickListener {
            val intent = Intent(this, StoreActivity::class.java)
            startActivity(intent)
        }

        //play audio on instrument button clicks
        val bassAudio: MediaPlayer = MediaPlayer.create(this, R.raw.bassline)
        val playBass = findViewById<Button>(R.id.btnBass)
        playBass.setOnClickListener {
            bassAudio.start()
        }

        val drumsAudio: MediaPlayer = MediaPlayer.create(this, R.raw.drumloop)
        val playDrums = findViewById<Button>(R.id.btnDrums)
        playDrums.setOnClickListener {
            drumsAudio.start()
        }
        val guitarAudio: MediaPlayer = MediaPlayer.create(this, R.raw.guitar)
        val playGuitar = findViewById<Button>(R.id.btnGuitar)
        playGuitar.setOnClickListener {
            guitarAudio.start()
        }



    }
}


