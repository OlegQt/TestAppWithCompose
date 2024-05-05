package com.oleg.testappwithcompose.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RootViewModel : ViewModel() {
    private var shadowAngle: Float = 0.0F

    private val _count = MutableLiveData<Float>(0F)
    val count = _count as LiveData<Float>

    init {
        startCount()
    }

    private fun startCount() {
        viewModelScope.launch {
            while (true) {
                delay(24)
                shadowAngle += 0.05F

                _count.value = shadowAngle
            }
        }
    }
}