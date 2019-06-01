package com.apps.michaeldow.projectdao.mainactivity.chat

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.Query

class ChatViewModel : ViewModel() {

    private val database = ChatDatabaseProvider()

    fun getQuery(): Query {
        return database.getChatQuery()
    }


}