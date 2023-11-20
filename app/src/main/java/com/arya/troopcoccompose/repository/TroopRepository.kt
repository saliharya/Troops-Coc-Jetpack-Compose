package com.arya.troopcoccompose.repository

import com.arya.troopcoccompose.database.FavoriteTroopDao
import com.arya.troopcoccompose.model.Troop
import com.arya.troopcoccompose.model.troops
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TroopRepository @Inject constructor(private val mFavoriteTroopDao: FavoriteTroopDao) {
    fun getTroops(): List<Troop> {
        return troops
    }

    fun searchTroops(query: String): List<Troop> {
        return troops.filter {
            it.name?.contains(query, ignoreCase = true) == true
        }
    }

    suspend fun getFavoriteTroops(): List<Troop> = mFavoriteTroopDao.getFavoriteTroops()

    suspend fun insertToFavorite(troop: Troop) {
        mFavoriteTroopDao.insertFavoriteTroop(troop)
    }

    suspend fun deleteFromFavorite(troop: Troop) {
        mFavoriteTroopDao.deleteFavoriteTroop(troop)
    }

    suspend fun checkIsFavoriteById(id: String): Boolean {
        return mFavoriteTroopDao.getTroopById(id).any()
    }
}

