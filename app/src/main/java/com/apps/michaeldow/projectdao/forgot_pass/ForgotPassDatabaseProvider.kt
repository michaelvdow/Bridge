package com.apps.michaeldow.projectdao.forgot_pass

import androidx.navigation.fragment.NavHostFragment
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ForgotPassDatabaseProvider {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun sendReset(email: String): Task<AuthResult> {
        return auth.sendPasswordResetEmail(email).addOnCompleteListener(new onCompleteListener<AuthResult>() {})
    }
}