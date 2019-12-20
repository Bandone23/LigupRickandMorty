package com.example.liguprickandmorty.presentation

import androidx.lifecycle.ViewModel
import com.example.core.extension.LiveResult
import com.example.liguprickandmorty.domain.model.CharacterList
import com.example.liguprickandmorty.domain.usecase.GetCharacterUseCase
import com.example.liguprickandmorty.ui.adapter.CharacterAdapter

class CharacterViewModel(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    lateinit var adapter: CharacterAdapter

    val characterLiveData = LiveResult<List<CharacterList>>()


    fun getCharacter () {
        getCharacterUseCase.execute(liveData = characterLiveData)
    }

    fun initAdapter(clickListener:(CharacterList,Int)-> Unit){
        adapter = CharacterAdapter(mutableListOf(),clickListener)
    }

    fun updateCharacter(songList: List<CharacterList>) {
        adapter.setData(songList)
        adapter.notifyDataSetChanged()
    }
}