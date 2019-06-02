package com.apps.michaeldow.projectdao.forgot_pass

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apps.michaeldow.projectdao.utils.SingleEvent
import com.google.firebase.auth.FirebaseAuth
import android.os.Bundle
import android.widget.Toast
import android.text.TextUtils
import com.apps.michaeldow.projectdao.login.LoginDatabaseProvider
import android.util.Log

class ForgotPassViewModel: ViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val resetSent = SingleEvent()
    private val databaseProvider = ForgotPassDatabaseProvider()

    fun onSignInClick() {
        val emailval = email.value;
        if (emailval != null) {
            databaseProvider.onResetClick(emailval).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    resetSent.fire()

                }
            }
        }

    }


}