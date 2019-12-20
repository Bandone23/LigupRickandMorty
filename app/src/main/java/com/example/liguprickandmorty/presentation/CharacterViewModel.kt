package com.example.liguprickandmorty.presentation

import androidx.lifecycle.ViewModel
import com.example.core.extension.LiveResult
import com.example.liguprickandmorty.domain.model.CharacterList
import com.example.liguprickandmorty.domain.usecase.GetCharacterUseCase

class CharacterViewModel(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    val characterLiveData = LiveResult<List<CharacterList>>()


    fun getCharacter () {
        getCharacterUseCase.execute(liveData = characterLiveData)
    }
}