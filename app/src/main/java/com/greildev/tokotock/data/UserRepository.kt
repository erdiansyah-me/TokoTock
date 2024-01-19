package com.greildev.tokotock.data

import kotlinx.coroutines.flow.Flow

interface UserRepository{
  suspend fun saveUserOnboardingPreferences(isShowOnboarding: Boolean)
  fun getUserOnboardingPreferences() : Flow<Boolean>

  suspend fun saveUserThemePreferences(isDarkTheme: Boolean)

  fun getUserThemePreferences(): Flow<Boolean>
}
class UserRepositoryImpl(
    private val userPreferencesRepository: UserPreferencesRepository
) : UserRepository {
    override suspend fun saveUserOnboardingPreferences(isShowOnboarding: Boolean) = userPreferencesRepository.saveUserOnBoardingPreferences(isShowOnboarding = isShowOnboarding)
    override fun getUserOnboardingPreferences() = userPreferencesRepository.getUserOnboardingPreferences()
    override suspend fun saveUserThemePreferences(isDarkTheme: Boolean) {
        userPreferencesRepository.saveUserThemePreferences(isDarkTheme = isDarkTheme)
    }

    override fun getUserThemePreferences(): Flow<Boolean>  = userPreferencesRepository.getUserThemePreferences()


}