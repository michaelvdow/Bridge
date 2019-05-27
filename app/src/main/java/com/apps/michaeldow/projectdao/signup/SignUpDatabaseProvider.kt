package com.apps.michaeldow.projectdao.signup

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class SignUpDatabaseProvider {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun signUpUser(email: String, password: String): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password)
    }

}