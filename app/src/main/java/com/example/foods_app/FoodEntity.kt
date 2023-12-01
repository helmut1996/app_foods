package com.example.foods_app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FoodEntity (
    @PrimaryKey(autoGenerate = true)
    var id_food:Long,
    var name:String,
    var type:String
    )