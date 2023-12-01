package com.example.foods_app

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule{
    @Singleton
    @Binds
    abstract fun binDataSource(impl:FoodDataSourceRoom): DataSource
}

@InstallIn(SingletonComponent::class)
@Module
object RoomModule{
    @Singleton
    @Provides
    fun provideDao(database: FoodDatabase): FoodDao = database.foodDao()


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app:Context): FoodDatabase =  Room.databaseBuilder(
            app,
            FoodDatabase::class.java,
            "FoodDatabase"
        ).build()
}
