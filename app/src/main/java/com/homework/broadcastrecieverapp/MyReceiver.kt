package com.homework.broadcastrecieverapp

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class MyReceiver : BroadcastReceiver() {

    private var messageId = 0
    override fun onReceive(context: Context, intent: Intent) {
        var message = intent.getStringExtra(KEY_MESSAGE)
        if (message == null){
            message = ""
        }
        val notification = NotificationCompat.Builder(context,"2")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Broadcast Receiver")
            .setContentText(message)
            .build()

      val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(messageId++,notification)
}
}