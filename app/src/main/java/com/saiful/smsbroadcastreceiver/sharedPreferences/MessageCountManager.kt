package com.saiful.smsbroadcastreceiver.sharedPreferences

import android.content.Context
import android.content.SharedPreferences

class MessageCountManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MessageCount", Context.MODE_PRIVATE)

    fun saveData(key: String, value: String) {
        val getCount = getData(key) ?: 0
        var valueCount = getCount.toString().toInt().plus(value.toInt()).toString()
        sharedPreferences.edit().putString(key, valueCount).apply()
    }

    private fun getData(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun getAll(): Map<String, *> {
        return sharedPreferences.all
    }
}
