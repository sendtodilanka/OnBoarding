package com.codeboxlk.tutorial.onboarding.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeboxlk.tutorial.onboarding.data.DataStoreManager
import com.codeboxlk.tutorial.onboarding.data.DataStoreManager.Companion.onBoardingKey
import com.codeboxlk.tutorial.onboarding.navigation.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {
    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination = mutableStateOf(Screen.Welcome.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreManager.readValue(onBoardingKey).collect { completed ->
                if (completed == true) {
                    _startDestination.value = Screen.Home.route
                } else {
                    _startDestination.value = Screen.Welcome.route
                }
            }
            _isLoading.value = false
        }
    }
}