package com.overlord.app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.overlord.common.DiagnosticsAPI
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val name = MutableLiveData("Hello")

    fun getResponse() {
        viewModelScope.launch {
            val result = DiagnosticsAPI.helloWorld()
            name.postValue(result.text)
        }
    }
}
