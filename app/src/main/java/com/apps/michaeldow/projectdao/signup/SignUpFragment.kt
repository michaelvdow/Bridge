package com.apps.michaeldow.projectdao.signup

import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.apps.michaeldow.projectdao.R
import com.apps.michaeldow.projectdao.databinding.FragmentSignupBinding
import kotlinx.android.synthetic.main.fragment_signup.*

class SignUpFragment: Fragment() {

    private lateinit var viewModel: SignUpViewModel
    private lateinit var binding: FragmentSignupBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.show()

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
        binding.viewModel = viewModel

        setupObservers()

        return binding.root
    }

    private fun setupObservers() {
        viewModel.isSignedUp.observe(this, Observer { isSignedUp ->
            if (isSignedUp) {
                findNavController().navigate(R.id.action_signUpFragment_to_chatFragment)
            }
        })

        viewModel.viewPass.observe(this, Observer { viewPass ->
            if (viewPass) {
                passwordInput.transformationMethod = PasswordTransformationMethod.getInstance()
            }
            else{
                passwordInput.transformationMethod = HideReturnsTransformationMethod.getInstance()
            }
        })

        viewModel.signUpFailed.observe(this, Observer { signUpFailed ->
            Toast.makeText(context, "Sign up failed", Toast.LENGTH_SHORT).show()
        })
    }

}