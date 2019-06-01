package com.apps.michaeldow.projectdao.forgot_pass

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apps.michaeldow.projectdao.login.LoginDatabaseProvider
import com.apps.michaeldow.projectdao.utils.SingleEvent

class ForgotPassViewModel: ViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val isSignedIn = MutableLiveData<Boolean>()
    val forgotPass = MutableLiveData<Boolean>()
    val signInFailed = SingleEvent()
    private val databaseProvider = LoginDatabaseProvider()

    init {
        isSignedIn.value = false
    }

    fun onForgotPassClick(){
        forgotPass.value = true
    }

    fun onResetClick() {

    }

}