package com.example.liguprickandmorty.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core.coroutines.Result
import com.example.core.extension.observe

import com.example.liguprickandmorty.R
import com.example.liguprickandmorty.databinding.FragmentCharacterBinding
import com.example.liguprickandmorty.domain.model.CharacterList
import com.example.liguprickandmorty.presentation.CharacterViewModel
import com.example.liguprickandmorty.ui.activity.BaseFragment
import org.jetbrains.anko.support.v4.longToast
import org.jetbrains.anko.support.v4.toast
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterFragment : BaseFragment() {

    companion object {
        fun newInstance() = CharacterFragment()
    }

    private val viewModel: CharacterViewModel by viewModel()
    lateinit var binding: FragmentCharacterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel.initAdapter { character: CharacterList, viewId: Int ->
            characterClicked(
                character,
                viewId
            )
        }
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val layoutManger = (LinearLayoutManager(activity, RecyclerView.VERTICAL, false))
        binding.recyclerRickAndMorty.layoutManager = layoutManger


        with(viewModel) {
            observe(characterLiveData, ::characterObserver)
        }
        viewModel.getCharacter()

        return binding.root
    }


    private fun characterObserver(result: Result<List<CharacterList>>?) {
        when (result) {
            is Result.OnLoading -> {
                binding.progressCircular.visibility =View.VISIBLE
            }
            is Result.OnSuccess -> {
                if (result.value.isNotEmpty()) {
                    binding.progressCircular.visibility =View.GONE

                    viewModel.updateCharacter(result.value)
                    toast("datos cargados correctamente ")
                } else {
                    longToast("lista sin caracteres")
                }

            }
            is Result.OnError -> {
                binding.progressCircular.visibility =View.GONE
                onError()
            }
            is Result.OnCancel -> {
            }
            else -> {
            }
        }
    }

    private fun characterClicked(character: CharacterList, viewId: Int) {
        when (viewId) {
            R.id.card_character -> {
                toast(character.name +" id : "+ character.id.toString())


            }

        }
    }


}
