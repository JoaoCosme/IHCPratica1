package com.ihcpratica1.android

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    var mutableValue by mutableStateOf("Default")
        private set

    fun updateMutableValue(newValue: String) {
        mutableValue = newValue
    }
}