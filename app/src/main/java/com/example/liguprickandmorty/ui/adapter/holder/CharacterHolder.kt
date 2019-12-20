package com.example.liguprickandmorty.ui.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.liguprickandmorty.R
import com.example.liguprickandmorty.databinding.ItemCharacterBinding
import com.example.liguprickandmorty.domain.model.CharacterList
import com.example.liguprickandmorty.util.getImgPicasso

class CharacterHolder(
    private val binding: ItemCharacterBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bindEvent(character: CharacterList,clickListener: (CharacterList, Int) -> Unit) {
        binding.character = character
        binding.cardCharacter.setOnClickListener{ clickListener(character, R.id.card_character)}
        getImgPicasso(character.image,binding.imageView)
        binding.executePendingBindings()
    }


}