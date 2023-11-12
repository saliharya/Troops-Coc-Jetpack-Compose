package com.arya.troopcoccompose.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val imgUrl: String,
    val email: String
) : Parcelable