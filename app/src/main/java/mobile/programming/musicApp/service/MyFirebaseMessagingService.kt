package mobile.programming.musicApp.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService : FirebaseMessagingService() {


    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.i("FirebaseService ", "Refreshed token :: $token")

        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String) {

    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.i("FirebaseService ", "Message :: $message")
    }
}