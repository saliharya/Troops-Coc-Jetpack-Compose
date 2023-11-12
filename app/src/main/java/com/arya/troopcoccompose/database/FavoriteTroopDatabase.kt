package com.arya.troopcoccompose.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arya.troopcoccompose.model.User

@Database(entities = [User::class], version = 1)
abstract class FavoriteTroopDatabase : RoomDatabase() {
    abstract fun favoriteTroopDao(): FavoriteTroopDao
}