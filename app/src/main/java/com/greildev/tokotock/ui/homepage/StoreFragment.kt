package com.greildev.tokotock.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.greildev.tokotock.databinding.FragmentStoreBinding

class StoreFragment : Fragment() {
    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding!!

    private var onBottomSheetButtonClicked: BottomSheetOnClickFilterListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.storeError.isVisible = true
        binding.storeError.setErrorMessage(
            title = "DWASDWA",
            description = "dwasddddddddddddddddddddd",
            btnTitle = "awdasd",
            action = {

            }
        )
        binding.btnChipFilter.setOnClickListener {
            onBottomSheetButtonClicked?.onFilterClick()
        }
    }

    fun setOnBottomSheetClickListener(onClickFilterListener: BottomSheetOnClickFilterListener) {
        this.onBottomSheetButtonClicked = onClickFilterListener
    }
}

interface BottomSheetOnClickFilterListener {
    fun onFilterClick()
}