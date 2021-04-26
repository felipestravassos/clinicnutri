package com.orionft.clinicnutri.ui.createaccount.namegender

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.orionft.clinicnutri.R
import com.orionft.clinicnutri.databinding.FragmentCreateAccountNameGenderBinding
import com.orionft.clinicnutri.ui.createaccount.CreateAccountViewModel

class PersonalInfFragment : Fragment() {

    private lateinit var binding: FragmentCreateAccountNameGenderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = activity?.let { ViewModelProvider(it).get(CreateAccountViewModel::class.java) }

        binding = FragmentCreateAccountNameGenderBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel?.nextEvent?.observe(this, Observer {
            Navigation.findNavController(binding.root).navigate(it)
        })

        return binding.root
    }
}