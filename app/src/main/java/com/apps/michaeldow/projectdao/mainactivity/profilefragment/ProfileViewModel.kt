package com.apps.michaeldow.projectdao.mainactivity.profilefragment

import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel: ViewModel() {

    val name = MutableLiveData<String>()
    private val database: ProfileDataProvider = ProfileDataProvider()

    init {
        database.getProfile().addOnSuccessListener { document ->
            if (document != null) {
                name.value = document.getString("name")
            }
        }
    }

    fun onButtonClick() {
        if (name.value != null) {
            database.setName(name.value)
        }
    }
}