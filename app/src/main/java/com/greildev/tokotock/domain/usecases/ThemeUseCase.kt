package com.greildev.tokotock.domain.usecases

import com.greildev.tokotock.data.UserRepository
import kotlinx.coroutines.flow.Flow

class ThemeUseCase (private val userRepository: UserRepository) {
    suspend fun saveUserThemePreferences(isDarkTheme: Boolean) {
        userRepository.saveUserThemePreferences(isDarkTheme = isDarkTheme)
    }

    fun getUserThemePreferences() : Flow<Boolean> = userRepository.getUserThemePreferences()
}