package com.example.weatherator.ui.splash_screan

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weatherator.databinding.FragmentSpashScreenBinding

const val SPLASH_SCREEN_TIME_OUT = 5000L

class SplashScreenFragment : Fragment() {
    private var _binding: FragmentSpashScreenBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, bundle: Bundle?
    ): View? {
        _binding = FragmentSpashScreenBinding.inflate(inflater, container, false)
        Handler().postDelayed(
            { findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToMainFragment()) },
            SPLASH_SCREEN_TIME_OUT
        )
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}