package com.example.liguprickandmorty.data.remote.model

import com.example.liguprickandmorty.domain.model.CharacterList

data class CharacterListEntry (
    val id:Int,
    val name:String,
    val status:String,
    val species:String,
    val type:String,
    val gender:String,
    val origin:OriginEntry,
    val location:LocationEntry,
    val image:String
)

fun CharacterListEntry.toCharacterList()= CharacterList (
    id =id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    origin = origin.toOrigin(),
    location = location.toLocation(),
    image = image
)
