package com.example.liguprickandmorty.data.remote.model

import com.example.liguprickandmorty.domain.model.Location

data class LocationEntry (
    val name:String,
    val url:String
)

fun LocationEntry.toLocation() = Location (
    name=name,
    url = url
)