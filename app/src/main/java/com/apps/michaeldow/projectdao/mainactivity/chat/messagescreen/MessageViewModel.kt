package com.apps.michaeldow.projectdao.mainactivity.chat.messagescreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.Query

class MessageViewModel : ViewModel() {

    private val database = MessageDatabaseProvider()
    lateinit var otherUser: String

    val sendText = MutableLiveData<String>()

    fun getQuery(otherUser: String): Query {
        return database.getChatQuery(otherUser)
    }

    fun onSendClick() {
        val sendTextValue = sendText.value
        if (sendTextValue != null && sendTextValue != "") {
            database.sendMessage(sendTextValue)
        }
        sendText.value = ""
    }

}