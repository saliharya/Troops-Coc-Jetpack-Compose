package com.arya.troopcoccompose.repository

import com.arya.troopcoccompose.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor() {
    fun getUserData(): User {
        return User(
            "Salih Arya Gumilang",
            "https://upload.wikimedia.org/wikipedia/en/thumb/9/94/NarutoCoverTankobon1.jpg/220px-NarutoCoverTankobon1.jpg",
            "saliharyazinc@gmail.com"
        )
    }
}