package com.example.foods_app

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FoodDao {
@Query("Select * from FoodEntity")
suspend fun getFood(): List<FoodEntity>


@Insert
suspend fun insertFood(foodEntity: FoodEntity):Long
}