package com.example.liguprickandmorty.ui.activity


import android.os.Bundle
import com.example.liguprickandmorty.R
import com.example.liguprickandmorty.ui.fragment.CharacterFragment

class MainActivity : BaseActivity() {

    private var fragmentcharacter: CharacterFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentcharacter = CharacterFragment.newInstance()
        addFragment(fragmentcharacter!!, "character rick and morty ")
    }
}
