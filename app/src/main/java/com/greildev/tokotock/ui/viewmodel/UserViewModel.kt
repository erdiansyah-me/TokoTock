package com.greildev.tokotock.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.greildev.tokotock.domain.usecases.OnboardingUseCase
import com.greildev.tokotock.domain.usecases.ThemeUseCase
import kotlinx.coroutines.launch

class UserViewModel(
    private val onboardingUseCase: OnboardingUseCase,
    private val themeUseCase: ThemeUseCase
) :  ViewModel() {
    val getUserOnboardingPreferences = onboardingUseCase.getUserOnboardingPreferences().asLiveData()

    fun setUserOnboardingPreferences(isShowOnboarding: Boolean) {
        viewModelScope.launch {
            onboardingUseCase.saveUserOnboardingPreferences(isShowOnboarding)
        }
    }

    val getUserThemePrefences = themeUseCase.getUserThemePreferences().asLiveData()

    fun setUserThemePreferences(isDarkTheme: Boolean) {
        viewModelScope.launch {
            themeUseCase.saveUserThemePreferences(isDarkTheme)
        }
    }
}