package com.example.assignment2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "com.example.MY_ACTION") {
            Toast.makeText(context, "Broadcast Received", Toast.LENGTH_SHORT).show()
        }
    }

}