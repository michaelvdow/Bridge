package com.apps.michaeldow.projectdao.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.michaeldow.projectdao.R
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.ActionCodeSettings

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}