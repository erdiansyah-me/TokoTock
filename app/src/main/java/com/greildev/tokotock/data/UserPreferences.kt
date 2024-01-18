//package com.greildev.tokotock.data
//
//import android.content.Context
//import androidx.datastore.core.DataStore
//import androidx.datastore.preferences.core.Preferences
//import androidx.datastore.preferences.preferencesDataStore
//import com.greildev.tokotock.App
//import org.koin.core.context.KoinContext
//
//private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name= "UserPreferences")
//class UserPreferencesRepository(private val dataStore: DataStore<Preferences>, context: Context){
//
//    private val dataStore = app.applicationContext.dataStore
//
//
//
//    companion object {
//
//    }
//}
//
//data class UserPreferences(
//    val showOnboarding: Boolean,
//    val isDarkTheme:
//    )