package com.homework.broadcastrecieverapp

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class MyReceiver : BroadcastReceiver() {

    private var messageId = 0
    override fun onReceive(context: Context, intent: Intent) {
        var message = intent.getStringExtra("key2")
        if (message == null){
            message = ""
        }
        val notificationCompat: NotificationCompat.Builder = NotificationCompat.Builder(context,"2")
        notificationCompat.apply {
            setSmallIcon(R.mipmap.ic_launcher)
            setContentTitle("Broadcast Receiver")
            setContentText(message)
        }
      val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(messageId++, notificationCompat.build())
}
}