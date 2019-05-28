package com.apps.michaeldow.projectdao.welcome

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel: ViewModel() {

    var signUp = MutableLiveData<Boolean>()
    var logIn = MutableLiveData<Boolean>()

    init {
        signUp.value = false
        logIn.value = false
    }

    fun onSignUpClick() {
        signUp.value = true
    }

    fun onLogInClick() {
        logIn.value = true
    }

}