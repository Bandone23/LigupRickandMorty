package com.example.liguprickandmorty.data.remote.model

import com.example.liguprickandmorty.domain.model.Origin

data class OriginEntry (
    val name:String,
    val url:String
)

fun OriginEntry.toOrigin()= Origin (
    name=name,
    url=url
)