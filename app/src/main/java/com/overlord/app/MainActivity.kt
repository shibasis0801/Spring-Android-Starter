package com.overlord.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.ui.platform.setContent
import com.overlord.common.Networking



class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Networking.initialise("http://${BuildConfig.IP_LOCAL_SERVER}:8080")

        setContent {
            MainScreen()
        }

        mainViewModel.getResponse()
    }
}
