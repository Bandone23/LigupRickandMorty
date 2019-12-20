package com.example.liguprickandmorty.data.repository

import com.example.liguprickandmorty.data.remote.model.toCharacterList
import com.example.liguprickandmorty.data.remote.source.CharacterRemoteDataSource
import com.example.liguprickandmorty.domain.model.CharacterList

class CharacterRepository (
    private val characterRemoteDataSource: CharacterRemoteDataSource
) {
    suspend fun getCharacter ():List<CharacterList> {
        return characterRemoteDataSource.getCharacter().map { it.toCharacterList() }
    }
}