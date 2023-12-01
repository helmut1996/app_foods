package com.example.foods_app

import javax.inject.Inject

class FakeDatabase @Inject constructor(){
fun getAllTypes(): List<Foodtype> = listOf(
    Foodtype(1,"Postres"),
    Foodtype(2,"Bebidas"),
    Foodtype(3,"Asiatica"),
    Foodtype(4,"Mexicana"),
    Foodtype(5,"Fancesa")
)

}