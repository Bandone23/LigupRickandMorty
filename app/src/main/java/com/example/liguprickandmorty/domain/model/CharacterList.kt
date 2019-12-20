package com.example.liguprickandmorty.domain.model

data class CharacterList (
    val id:Int,
    val name:String,
    val status:String,
    val species:String,
    val type:String,
    val gender:String,
    val origin: Origin,
    val location: Location,
    val image:String
)