package com.greildev.tokotock.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.isVisible
import com.greildev.tokotock.databinding.ErrorScreenBinding

class ErrorView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {
    private var binding: ErrorScreenBinding

    init {
        binding = ErrorScreenBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setErrorMessage(title:String, description: String, btnTitle: String = "", action: () -> (Unit)) = with(binding) {
        tvErrorTitle.text = title
        tvErrorDescription.text = description
        btnRetry.isVisible = btnTitle.isNotEmpty()
        btnRetry.text = btnTitle
        btnRetry.setOnClickListener {
            action.invoke()
        }
    }
}