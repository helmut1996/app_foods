package com.example.foods_app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FoodEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var price: Double = 0.0,
    var name: String = "",
    var type: Long = 0)