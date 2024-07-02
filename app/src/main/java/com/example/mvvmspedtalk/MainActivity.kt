package com.example.mvvmspedtalk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.mvvmspedtalk.Models.FirebaseHelper
import com.example.mvvmspedtalk.Viewmodels.AppViewModel
import com.example.mvvmspedtalk.Views.AppContent
import com.example.mvvmspedtalk.Views.theme.MVVMSpedTalkTheme

data class AppViewState(
    val name: String,
    val major: String,
    val age: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val firebaseHelper = FirebaseHelper()
        val viewModel = AppViewModel(firebaseHelper)

        setContent {

            val viewState by viewModel.viewState.collectAsState()

            MVVMSpedTalkTheme {
                AppContent(
                    viewState = viewState,
                    onChangeName = { viewModel.onChangeName(it) },
                    onChangeMajor = { viewModel.onChangeMajor(it) },
                    onChangeAge = { viewModel.onChangeAge(it) },
                    updateName = { viewModel.updateName() },
                    updateMajor = { viewModel.updateMajor() },
                    updateAge = { viewModel.updateAge() }
                )
            }
        }
    }
}
