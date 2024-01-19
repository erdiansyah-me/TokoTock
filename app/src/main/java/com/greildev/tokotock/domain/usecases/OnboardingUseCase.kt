package com.greildev.tokotock.domain.usecases

import com.greildev.tokotock.data.UserRepository
import kotlinx.coroutines.flow.Flow

class OnboardingUseCase (private val userRepository: UserRepository) {
    suspend fun saveUserOnboardingPreferences(isShowOnboarding: Boolean) {
        userRepository.saveUserOnboardingPreferences(isShowOnboarding = isShowOnboarding)
    }

    fun getUserOnboardingPreferences(): Flow<Boolean> = userRepository.getUserOnboardingPreferences()

}