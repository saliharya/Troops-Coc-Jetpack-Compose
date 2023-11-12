package com.arya.troopcoccompose.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arya.troopcoccompose.model.Troop

interface FavoriteTroopDao {
    @Query("SELECT * FROM Troop")
    suspend fun getFavoriteTroops(): List<Troop>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteTroop(troop: Troop)

    @Delete
    suspend fun deleteFavoriteTroop(troop: Troop)
}