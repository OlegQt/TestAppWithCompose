package com.oleg.testappwithcompose.Presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RootViewModel:ViewModel() {
    private val _count = MutableLiveData<Long>(0)
    val count = _count as LiveData<Long>

    init {
        startCount()
    }

    private fun startCount(){
        viewModelScope.launch {
            while (true) {
                delay(24)
                _count.value = _count.value?.plus(1)
            }
        }
    }
}