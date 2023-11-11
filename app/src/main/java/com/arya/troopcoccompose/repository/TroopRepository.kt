package com.arya.troopcoccompose.repository

import com.arya.troopcoccompose.model.Troop
import com.arya.troopcoccompose.model.troops
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TroopRepository @Inject constructor() {
    fun getTroops(): List<Troop> {
        return troops
    }

    fun searchTroops(query: String): List<Troop> {
        return troops.filter {
            it.name?.contains(query, ignoreCase = true) ?: false
        }
    }
}

