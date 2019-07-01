package com.apps.michaeldow.projectdao.mainactivity.chat.messagescreen

import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.lang.reflect.Field

class MessageDatabaseProvider {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun getChatQuery(otherUser: String): Query { // TODO: switch document to auth.getUID, create constants
        val uid = 1 // TODO: Set to uid
        return db.collection("chats").document().collection("messages").orderBy("timestamp")
    }

    fun sendMessage(sendText: String) {
        val message = hashMapOf(
            "message" to sendText,
            "type" to "text",
            "timestamp" to FieldValue.serverTimestamp(),
            "from" to 1
        )
        db.collection("chats").document("1_to_2").collection("messages").add(message)
    }

    fun create

}