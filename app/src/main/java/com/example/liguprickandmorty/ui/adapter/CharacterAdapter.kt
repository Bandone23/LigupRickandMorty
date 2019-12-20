package com.example.liguprickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.liguprickandmorty.R
import com.example.liguprickandmorty.databinding.ItemCharacterBinding
import com.example.liguprickandmorty.domain.model.CharacterList
import com.example.liguprickandmorty.ui.adapter.holder.CharacterHolder

class CharacterAdapter ( private var character: MutableList<CharacterList>,
private val clickListener: (CharacterList, Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding: ItemCharacterBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_character,
                parent,
                false
            )
        return CharacterHolder(itemBinding)
    }

    override fun getItemCount(): Int {
       return character.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = character[position]
        holder as CharacterHolder
        holder.bindEvent(item,clickListener)
    }

    fun setData(characterList: List<CharacterList>) {
        if (character.isNullOrEmpty()) {
            character = characterList.toMutableList()
        }else {
            character.clear()
            character.addAll(character.size,characterList)
        }

        notifyDataSetChanged()
    }
}