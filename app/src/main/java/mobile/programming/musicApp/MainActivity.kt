package mobile.programming.musicApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mobile.programming.musicapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

FirebaseInstanceId.getInstance().instanceId
        .addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "getInstanceId failed", task.exception)
                return@OnCompleteListener
            }

            // Get new Instance ID token
            val token = task.result?.token

            // Log and toast
            val msg = getString(R.string.msg_token_fmt, token)
            Log.d(TAG, msg)
            Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
        })

val fm = FirebaseMessaging.getInstance()
fm.send(RemoteMessage.Builder("$SENDER_ID@fcm.googleapis.com")
        .setMessageId(Integer.toString(messageId))
        .addData("my_message", "Hello World")
        .addData("my_action", "SAY_HELLO")
        .build())

FirebaseMessaging.getInstance().isAutoInitEnabled = true
