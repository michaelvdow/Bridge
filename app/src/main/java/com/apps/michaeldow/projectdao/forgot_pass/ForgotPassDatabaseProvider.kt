package com.apps.michaeldow.projectdao.forgot_pass

import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ForgotPassDatabaseProvider {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun onResetClick(email: String): Task<Void> {
        return auth.sendPasswordResetEmail(email)
    }
}