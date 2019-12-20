package com.example.liguprickandmorty.data.remote.net

import com.example.liguprickandmorty.data.remote.model.CharacterEntry
import retrofit2.Call
import retrofit2.http.GET

interface CharacterApi {
    @GET("character")
    fun getCharacter(): Call<CharacterEntry>
}