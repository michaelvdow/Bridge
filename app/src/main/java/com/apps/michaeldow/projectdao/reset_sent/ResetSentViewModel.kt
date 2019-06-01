//package com.apps.michaeldow.projectdao.reset_sent
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.apps.michaeldow.projectdao.utils.SingleEvent
//
//class ResetSentViewModel: ViewModel() {
//
//    val email = MutableLiveData<String>()
//    val password = MutableLiveData<String>()
//    val isSignedIn = MutableLiveData<Boolean>()
//    val signInFailed = SingleEvent()
//    private val databaseProvider = ResetSentDatabaseProvider()
//
//    init {
//        isSignedIn.value = false
//    }
//
//    fun onSignInClick() {
//        val emailValue = email.value
//        val passwordValue = password.value
//        if (emailValue != null && passwordValue != null) {
//            databaseProvider.signInUser(emailValue, passwordValue)
//                .addOnCompleteListener {task ->
//                    if (task.isSuccessful) {
//                        isSignedIn.value = true
//                    } else {
//                        signInFailed.fire()
//                    }
//                }
//        }
//    }
//
//
//}