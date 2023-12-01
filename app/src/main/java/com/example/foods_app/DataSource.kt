package com.example.foods_app

interface DataSource {
    suspend fun  getAllFood(callback: ( List<FoodEntity>)->Unit)
    suspend fun addFood(foodEntity: FoodEntity, callback: (Long)->Unit)
}