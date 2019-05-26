package com.apps.michaeldow.projectdao.mainactivity.profilefragment

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

class ProfileDataProvider {

    private var db = FirebaseFirestore.getInstance()

    fun getProfile(): Task<DocumentSnapshot> {
        return db.collection("profiles").document("testUser").get()
    }

    fun setName(name: String?): Task<Void> {
        val documentRef = db.collection("profiles").document("testUser")
        return documentRef.update("name", name)
    }

}