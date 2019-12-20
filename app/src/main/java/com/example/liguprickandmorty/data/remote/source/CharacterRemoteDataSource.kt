package com.example.liguprickandmorty.data.remote.source

import com.example.core.extension.await
import com.example.liguprickandmorty.data.remote.model.CharacterListEntry
import com.example.liguprickandmorty.data.remote.net.CharacterApi

open class CharacterRemoteDataSource(
    private val characterApi: CharacterApi
) {
    suspend fun getCharacter():List<CharacterListEntry> {
        return  characterApi.getCharacter().await()!!.results
    }
}