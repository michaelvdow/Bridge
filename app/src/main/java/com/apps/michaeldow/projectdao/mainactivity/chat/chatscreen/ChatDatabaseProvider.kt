package com.apps.michaeldow.projectdao.mainactivity.chat.chatscreen

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class ChatDatabaseProvider {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun getChatQuery(): Query { // TODO: switch document to auth.getUID, create constants
        return db.collection("profiles").document("1").collection("chats").orderBy("timestamp")
    }

}