package com.greildev.tokotock.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.greildev.tokotock.R
import com.greildev.tokotock.databinding.FragmentOnboardBinding

class OnboardFragment : Fragment() {

    private var _binding: FragmentOnboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardBinding.inflate(inflater, container, false)

        binding.btnJoinnow.setOnClickListener {
            findNavController().navigate(R.id.action_onboardFragment_to_registerFragment)
        }

        binding.tvSkip.setOnClickListener{
            findNavController().navigate(R.id.action_onboardFragment_to_loginFragment)
        }

        return binding.root
    }
}