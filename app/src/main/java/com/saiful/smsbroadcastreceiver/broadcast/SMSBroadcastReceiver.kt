package com.saiful.smsbroadcastreceiver.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.widget.Toast
import com.saiful.smsbroadcastreceiver.sharedPreferences.MessageCountManager

class SMSBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (!intent.action.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) return
        val smsMessage = Telephony.Sms.Intents.getMessagesFromIntent(intent)

        var number = ""
        var message = ""
        for (sms in smsMessage) {
            number = sms.displayOriginatingAddress
            message = sms.displayMessageBody
        }

        val messageCountManager = MessageCountManager(context)
        messageCountManager.saveData(number, "1")

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}