package com.apps.michaeldow.projectdao.login

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val isSignedIn = MutableLiveData<Boolean>()
    private val databaseProvider = LoginDatabaseProvider()

    init {
        isSignedIn.value = false
    }

    fun onSignInClick() {
        val emailValue = email.value
        val passwordValue = password.value
        if (emailValue != null && passwordValue != null) {
            databaseProvider.signInUser(emailValue, passwordValue)
                .addOnCompleteListener {task ->
                    if (task.isSuccessful) {
                        isSignedIn.value = true
                    } else {
                        println("FAILED TO SIGN IN")
//                        Toast.makeText()
                    }
                }
        }
    }


}