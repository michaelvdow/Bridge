package com.apps.michaeldow.projectdao.forgot_pass

import android.os.Bundle
import android.util.Log
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
import com.apps.michaeldow.projectdao.databinding.FragmentForgotPassBinding


class ForgotPassFragment: Fragment() {

    private lateinit var viewModel: ForgotPassViewModel
    private lateinit var binding: FragmentForgotPassBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.show()

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forgot_pass, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(ForgotPassViewModel::class.java)
        binding.viewModel = viewModel

        setupObservers()

        return binding.root
    }

    private fun setupObservers() {
        viewModel.resetSent.observe(this, Observer { resetSent ->
            if (resetSent) {
                Log.d("TAG", "bitch")
                Toast.makeText(context, "Reset email sent", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_forgotPassFragment_to_loginFragment)
            }
        })



    }

}