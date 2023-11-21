package com.arya.troopcoccompose.repository

import com.arya.troopcoccompose.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor() {
    fun getUserData(): User {
        return User(
            "Salih Arya Gumilang",
            "https://media.licdn.com/dms/image/D5603AQFheIONMPeQdg/profile-displayphoto-shrink_800_800/0/1693733968053?e=1706140800&v=beta&t=rOUKhOzFD_HNdRL1GFGVrtNXez6F2Ip8hnH_cdM93ps",
            "saliharyazinc@gmail.com"
        )
    }
}