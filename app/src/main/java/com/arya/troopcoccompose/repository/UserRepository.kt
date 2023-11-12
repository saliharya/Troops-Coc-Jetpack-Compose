package com.arya.troopcoccompose.repository

import com.arya.troopcoccompose.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor() {
    fun getUserData(): User {
        return User(
            "Salih Arya Gumilang",
            "https://media.licdn.com/dms/image/D5603AQFheIONMPeQdg/profile-displayphoto-shrink_800_800/0/1693733966528?e=2147483647&v=beta&t=KbEAWIqz9AdG54hhiIJlfqr6n0JfbOdwKHdAwKivxAE",
            "saliharyazinc@gmail.com"
        )
    }
}