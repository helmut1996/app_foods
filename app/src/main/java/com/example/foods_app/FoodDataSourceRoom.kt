package com.example.foods_app

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoodDataSourceRoom @Inject constructor(private  val dao: FoodDao): DataSource {
    override suspend fun getAllFood(callback: (List<FoodEntity>) -> Unit) {
    callback(dao.getFood())
    }

    override suspend fun addFood(foodEntity: FoodEntity, callback: (Long) -> Unit) {
        val result = dao.insertFood(foodEntity)
        callback(result)
    }

}