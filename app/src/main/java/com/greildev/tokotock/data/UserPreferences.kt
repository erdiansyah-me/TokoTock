package com.greildev.tokotock.data

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name= "UserPreferences")
class UserPreferencesRepository(app:Application){

    private val dataStore = app.applicationContext.dataStore

    suspend fun saveUserOnBoardingPreferences(isShowOnboarding: Boolean) {
        dataStore.edit {
            it[ONBOARDING_KEY] = isShowOnboarding
        }
    }

    suspend fun saveUserThemePreferences(isDarkTheme: Boolean) {
        dataStore.edit {
            it[THEME_KEY] = isDarkTheme
        }
    }

    suspend fun saveUserLanguagePreferences(language: String) {
        dataStore.edit {
            it[LANG_KEY] = language
        }
    }

    fun getUserThemePreferences():Flow<Boolean> {
        return dataStore.data.map {
            it[THEME_KEY] ?: false
        }
    }

    fun getUserOnboardingPreferences(): Flow<Boolean> {
        return dataStore.data.map {
            it[ONBOARDING_KEY] ?: true
        }

    }

    fun getUserLanguagePreferences(): Flow<String> {
        return dataStore.data.map {
            it[LANG_KEY] ?: ""
        }
    }



    companion object {
        private val ONBOARDING_KEY = booleanPreferencesKey("isShowOnboarding")
        private val THEME_KEY = booleanPreferencesKey("isDarkTheme")
        private val LANG_KEY = stringPreferencesKey("language")

    }
}