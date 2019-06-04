package com.apps.michaeldow.projectdao.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apps.michaeldow.projectdao.utils.SingleEvent

class SignUpViewModel: ViewModel() {

    private val database = SignUpDatabaseProvider()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val isSignedUp = MutableLiveData<Boolean>()
    val signUpFailed = SingleEvent()
    val viewPass = MutableLiveData<Boolean>()


    init {
        isSignedUp.value = false
        viewPass.value = true
    }

    fun onViewPass() {
        if(viewPass.value == true){
            viewPass.value = false
        }
        else{
            viewPass.value = true
        }
    }

    fun onSignUpClick() {
        val emailValue = email.value
        val passwordValue = password.value
        if (emailValue != null && passwordValue != null) {
            database.signUpUser(emailValue, passwordValue).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    isSignedUp.value = true
                } else {
                    signUpFailed.fire()
                }
            }
        }
    }
}