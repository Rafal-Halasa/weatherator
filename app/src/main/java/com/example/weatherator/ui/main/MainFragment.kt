package com.example.weatherator.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.weatherator.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, bundle: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.showDetailViewEvent.observe(
            viewLifecycleOwner,
            Observer {
                findNavController().navigate(
                    MainFragmentDirections.actionMainFragmentToDetailFragment(
                        it.key,
                        it.localizedName
                    )
                )
            })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}