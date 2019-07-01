package com.apps.michaeldow.projectdao.mainactivity.chat.messagescreen

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.Query

class MessageViewModel : ViewModel() {

    private val database = MessageDatabaseProvider()

    fun getQuery(): Query {
        return database.getChatQuery()
    }


}