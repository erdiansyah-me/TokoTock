package com.greildev.tokotock.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.greildev.tokotock.R
import com.greildev.tokotock.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        val splashYellow = ObjectAnimator.ofFloat(binding.splashYellow, View.ROTATION,  -20f).setDuration(1000)
        val splashRed = ObjectAnimator.ofFloat(binding.splashRed, View.ROTATION,  15f).setDuration(1000)
        val splashGreen = ObjectAnimator.ofFloat(binding.splashGreen, View.TRANSLATION_Y, -100f).setDuration(1000)

        AnimatorSet().apply {
            playTogether(splashYellow, splashGreen,splashRed)
            start()
        }

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_onboardFragment)
        }, 2000)

        return binding.root
    }


}