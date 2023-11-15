package com.arya.troopcoccompose.di

import android.content.Context
import androidx.room.Room
import com.arya.troopcoccompose.database.FavoriteTroopDao
import com.arya.troopcoccompose.database.FavoriteTroopDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {
    @Provides
    @Singleton
    fun provideFavoriteTroopRoomDatabase(
        @ApplicationContext context: Context
    ): FavoriteTroopDatabase {
        return Room.databaseBuilder(
            context, FavoriteTroopDatabase::class.java, "favorite_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFavoriteTroopDao(
        favoriteTroopRoomDatabase: FavoriteTroopDatabase
    ): FavoriteTroopDao {
        return favoriteTroopRoomDatabase.favoriteTroopDao()
    }
}
