package com.orionft.clinicnutri.ui.createaccount.emailphone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.orionft.clinicnutri.databinding.FragmentContactBinding
import com.orionft.clinicnutri.ui.createaccount.CreateAccountViewModel

class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = activity?.let { ViewModelProvider(it).get(CreateAccountViewModel::class.java) }

        binding = FragmentContactBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel?.nextEvent?.observe(this, Observer {
            Navigation.findNavController(binding.root).navigate(it)
        })
        viewModel?.previousEvent?.observe(this, Observer {
            Navigation.findNavController(binding.root).popBackStack()
        })

        return binding.root
    }
}