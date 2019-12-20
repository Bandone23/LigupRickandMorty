package com.example.liguprickandmorty.data.remote.model

data class CharacterEntry (
    val info :InfoEntry,
    val results: List<CharacterListEntry>
)