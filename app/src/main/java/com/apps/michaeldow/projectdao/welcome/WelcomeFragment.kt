package com.apps.michaeldow.projectdao.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.apps.michaeldow.projectdao.R
import com.apps.michaeldow.projectdao.databinding.FragmentWelcomeBinding

class WelcomeFragment: Fragment() {

    private lateinit var viewModel: WelcomeViewModel
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.hide()

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(WelcomeViewModel::class.java)
        binding.viewModel = viewModel

        setupObservers()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    private fun setupObservers() {
        viewModel.signUp.observe(this, Observer { signUp ->
            if (signUp) {
                viewModel.signUp.value = false
                findNavController().navigate(R.id.action_welcomeFragment_to_signUpFragment)
            }
        })
        viewModel.logIn.observe(this, Observer { logIn ->
            if (logIn) {
                viewModel.logIn.value = false
                findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
            }
        })
    }

}