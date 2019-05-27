package com.apps.michaeldow.projectdao.MainActivity.ChatFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.apps.michaeldow.projectdao.R
import com.google.firebase.auth.FirebaseAuth

class ChatFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
        if (auth.currentUser == null) {
            findNavController().navigate(R.id.action_chatFragment_to_loginFragment)
        }
    }

    override fun onStart() {
        super.onStart()
    }
}