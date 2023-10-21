package com.codeboxlk.tutorial.onboarding.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.codeboxlk.tutorial.onboarding.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStoreManager(context: Context) {

    companion object {
        val onBoardingKey = booleanPreferencesKey(name = "on_boarding_completed")
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        context.getString(R.string.app_name)
    )

    private val dataStore = context.dataStore

    fun <T> readValue(key: Preferences.Key<T>): Flow<T?> {
        return dataStore.data.catch {
            if (it is IOException) emit(emptyPreferences()) else throw it
        }.map {
            it[key]
        }
    }

    suspend fun <T> storeValue(key: Preferences.Key<T>, value: T) {
        dataStore.edit { it[key] = value }
    }
}