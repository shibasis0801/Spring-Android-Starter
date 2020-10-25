package com.overlord.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.overlord.common.HelloWorld
import com.overlord.common.api.server.getDiagnosticsAPI
import kotlinx.coroutines.launch

class HelloViewModel: ViewModel() {
    private val diagnosticsAPI = getDiagnosticsAPI("http://${BuildConfig.IP_LOCAL_SERVER}:8080")
//    private val diagnosticsAPI = getDiagnosticsAPI("http://192.168.43.64:8080")
    val name = MutableLiveData("Hello")

    fun getResponse() {
        viewModelScope.launch {
            val result = diagnosticsAPI.helloWorld()
            name.postValue(result.text)
        }
    }
}

@Composable
fun HelloScreen(helloViewModel: HelloViewModel = viewModel()) {
    val name: String by helloViewModel.name.observeAsState("")

    Column {
        Text(text = name)
    }
}



class MainActivity : AppCompatActivity() {
    val helloViewModel by viewModels<HelloViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloScreen()
        }

        helloViewModel.getResponse()
    }
}
