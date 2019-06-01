package com.apps.michaeldow.projectdao.forgot_pass

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apps.michaeldow.projectdao.utils.SingleEvent

class ForgotPassViewModel: ViewModel() {

    val email = MutableLiveData<String>()

    private val databaseProvider = ForgotPassDatabaseProvider()

    init {
        isSignedIn.value = false
    }

    fun onResetClick() {

    }


}