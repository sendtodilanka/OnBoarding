package com.codeboxlk.tutorial.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeboxlk.tutorial.onboarding.data.DataStoreManager
import com.codeboxlk.tutorial.onboarding.data.DataStoreManager.Companion.onBoardingKey
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
): ViewModel() {

    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreManager.storeValue(onBoardingKey, completed)
        }
    }
}