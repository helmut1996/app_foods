package com.example.foods_app

import android.app.Application
import androidx.room.Room
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FoopApp:Application() {
//companion object {
//    lateinit var database: FoodDatabase
//}
//
//
//    override fun onCreate() {
//        super.onCreate()
//        database = Room.databaseBuilder(
//            this,
//            FoodDatabase::class.java,
//            "FoodDatabase"
//        ).build()
//    }
}