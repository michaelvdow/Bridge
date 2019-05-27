package com.apps.michaeldow.projectdao.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel: ViewModel() {

    private val database = SignUpDatabaseProvider()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val isSignedUp = MutableLiveData<Boolean>()
    val goToLogin = MutableLiveData<Boolean>()

    init {
        isSignedUp.value = false
        goToLogin.value = false
    }

    fun onSignUpClick() {
        val emailValue = email.value
        val passwordValue = password.value
        if (emailValue != null && passwordValue != null) {
            database.signUpUser(emailValue, passwordValue).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    isSignedUp.value = true
                }
            }
        }
    }

    fun onGoToLoginClick() {
        goToLogin.value = true
    }


}