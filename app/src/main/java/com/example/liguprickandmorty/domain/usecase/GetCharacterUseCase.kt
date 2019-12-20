package com.example.liguprickandmorty.domain.usecase

import com.example.core.coroutines.ResultUnitUseCase
import com.example.liguprickandmorty.data.repository.CharacterRepository
import com.example.liguprickandmorty.domain.model.CharacterList
import kotlinx.coroutines.Dispatchers

class GetCharacterUseCase(
    private val repository: CharacterRepository
) : ResultUnitUseCase<List<CharacterList>>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(): List<CharacterList>? {
        return repository.getCharacter()
    }

}