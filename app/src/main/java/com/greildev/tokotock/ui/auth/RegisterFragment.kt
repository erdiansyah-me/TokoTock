package com.greildev.tokotock.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.greildev.tokotock.R
import com.greildev.tokotock.databinding.FragmentRegisterBinding
import com.greildev.tokotock.utils.Utils

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.emailField.doAfterTextChanged {
            if (it != null) {
                if (!Utils.isEmailValid(it)) {
                    //emailLayout.helperText = "Email tidak Valid"
                    binding.emailLayout.error = "Email Tidak Valid"
                } else {
                    binding.emailLayout.isErrorEnabled = false
                }
            }
        }
        binding.passwordField.doAfterTextChanged {
            if (it != null) {
                if (it.length < 8) {
                    //passwordLayout.helperText = "Email tidak Valid"
                    binding.passwordLayout.error = "Password Tidak Valid"
                } else {
                    binding.passwordLayout.isErrorEnabled = false
                }
            }
        }
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
}