package com.greildev.tokotock.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.greildev.tokotock.R
import com.greildev.tokotock.databinding.FragmentSplashBinding
import com.greildev.tokotock.ui.viewmodel.UserViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null

    private val userViewModel: UserViewModel by viewModel()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val splashYellow = ObjectAnimator.ofFloat(binding.splashYellow, View.ROTATION,  -25f).setDuration(1000)
        val splashRed = ObjectAnimator.ofFloat(binding.splashRed, View.ROTATION,  18f).setDuration(1000)
        val splashGreen = ObjectAnimator.ofFloat(binding.splashGreen, View.TRANSLATION_Y, -100f).setDuration(1000)

        AnimatorSet().apply {
            playTogether(splashYellow, splashGreen,splashRed)
            start()
        }
        lifecycleScope.launch {
            delay(2000)
            userViewModel.getUserOnboardingPreferences.observe(viewLifecycleOwner) {
                if (it) {
                    findNavController().navigate(R.id.action_splashFragment_to_onboardFragment)
                } else {
                    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                }
            }
        }
    }

}