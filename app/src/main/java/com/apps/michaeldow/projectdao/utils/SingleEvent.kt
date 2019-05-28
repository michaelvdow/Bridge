package com.apps.michaeldow.projectdao.utils

import androidx.lifecycle.MutableLiveData

class SingleEvent: MutableLiveData<Boolean>() {

    fun fire() {
        val v = value
        if (v == null) {
            value = true
        } else {
            value = !v
        }
    }

}