package com.arya.troopcoccompose.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arya.troopcoccompose.model.User
import com.arya.troopcoccompose.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _userData = MutableLiveData<User>()
    val userData: LiveData<User> get() = _userData
    fun loadUserData() {
        viewModelScope.launch {
            val user = userRepository.getUserData()
            _userData.value = user
        }
    }
}