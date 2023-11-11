package com.arya.troopcoccompose.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String = "Salih Arya Gumilang",
    val imgUrl: String = "https://media.licdn.com/dms/image/D5603AQFheIONMPeQdg/profile-displayphoto-shrink_800_800/0/1693733966528?e=2147483647&v=beta&t=KbEAWIqz9AdG54hhiIJlfqr6n0JfbOdwKHdAwKivxAE",
    val email: String = "saliharyazinc@gmail.com",
) : Parcelable