package com.apps.michaeldow.projectdao.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.apps.michaeldow.projectdao.R
import com.apps.michaeldow.projectdao.databinding.FragmentSignupBinding

class SignUpFragment: Fragment() {

    private lateinit var viewModel: SignUpViewModel
    private lateinit var binding: FragmentSignupBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
        binding.viewModel = viewModel

        setupObservers()

        return binding.root
    }

    fun setupObservers() {
        viewModel.isSignedUp.observe(this, Observer { isSignedUp ->
            if (isSignedUp) {
                findNavController().navigate(R.id.action_signUpFragment_to_chatFragment)
            } else {
                Toast.makeText(context, "Sign up failed", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.goToLogin.observe(this, Observer { goToLogin ->
            if (goToLogin) {
                findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
            }
        })
    }

}