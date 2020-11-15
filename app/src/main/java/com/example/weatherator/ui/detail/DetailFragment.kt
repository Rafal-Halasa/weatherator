package com.example.weatherator.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.weatherator.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private val args: DetailFragmentArgs by navArgs()
    private var _binding: FragmentDetailBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, bundle: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return DetailViewModel(args) as T
            }
        }).get(DetailViewModel::class.java)
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
//        viewModel.imgWeatherUrl.observe(
//            viewLifecycleOwner,
//            Observer {
//                val test = it
//                Glide.with(this).load(it).into(binding.icWether)
//            })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}