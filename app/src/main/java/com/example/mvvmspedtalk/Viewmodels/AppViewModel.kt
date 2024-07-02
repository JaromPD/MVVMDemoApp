package com.example.mvvmspedtalk.Viewmodels

import androidx.lifecycle.ViewModel
import com.example.mvvmspedtalk.AppViewState
import com.example.mvvmspedtalk.Models.FirebaseHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AppViewModel(private val firebaseHelper: FirebaseHelper): ViewModel() {

    val _viewState = MutableStateFlow<AppViewState>(
        AppViewState(
            name = "",
            major = "",
            age = ""
        )
    )

    val viewState :StateFlow<AppViewState> = _viewState

    init {
        subscribeToUserData()
    }

    private fun subscribeToUserData() {
        firebaseHelper.subscribeToUserData { userData ->
            _viewState.value = _viewState.value.copy(
                name = userData?.name ?: "",
                major = userData?.major ?: "",
                age = userData?.age?.toString() ?: ""
            )
        }
    }

    fun onChangeName(name: String) {
        _viewState.value = _viewState.value.copy(name = name)
    }

    fun onChangeMajor(major: String) {
        _viewState.value = _viewState.value.copy(major = major)
    }

    fun onChangeAge(age: String) {
        _viewState.value = _viewState.value.copy(age = age)
    }

    fun updateName() {
        firebaseHelper.setName(_viewState.value.name)
    }

    fun updateMajor() {
        firebaseHelper.setMajor(_viewState.value.major)
    }

    fun updateAge() {
        firebaseHelper.setAge(_viewState.value.age.toInt())
    }

}