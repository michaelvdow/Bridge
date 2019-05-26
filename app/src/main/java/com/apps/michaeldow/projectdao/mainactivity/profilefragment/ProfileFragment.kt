package com.apps.michaeldow.projectdao.mainactivity.profilefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.apps.michaeldow.projectdao.R
import com.apps.michaeldow.projectdao.databinding.ProfileFragmentBinding


class ProfileFragment : Fragment() {

    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding: ProfileFragmentBinding

    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.profile_fragment, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)

        binding.viewModel = viewModel
        return binding.root
    }

}