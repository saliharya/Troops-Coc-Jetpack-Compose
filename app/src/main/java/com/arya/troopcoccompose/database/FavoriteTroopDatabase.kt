package com.arya.troopcoccompose.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arya.troopcoccompose.model.Troop

@Database(entities = [Troop::class], version = 1, exportSchema = false)
abstract class FavoriteTroopDatabase : RoomDatabase() {
    abstract fun favoriteTroopDao(): FavoriteTroopDao
}