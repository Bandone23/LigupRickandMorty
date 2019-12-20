package com.example.liguprickandmorty.di

import android.content.Context
import android.net.ConnectivityManager
import com.example.liguprickandmorty.URL_BASE_API
import com.example.liguprickandmorty.data.remote.net.CharacterApi
import com.example.liguprickandmorty.data.remote.source.CharacterRemoteDataSource
import com.example.liguprickandmorty.data.repository.CharacterRepository
import com.example.liguprickandmorty.domain.usecase.GetCharacterUseCase
import com.example.liguprickandmorty.presentation.CharacterViewModel
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {
    /* Android Services */
    single {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    /* Retrofit */
    single {
        OkHttpClient.Builder()
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(URL_BASE_API)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(CharacterApi::class.java) as CharacterApi }


    /* DataSource */
   factory { CharacterRemoteDataSource(get()) }

    /* Repositories */
    factory { CharacterRepository(get()) }

    /* UseCases */
    factory { GetCharacterUseCase(get()) }

/* View models */
    viewModel { CharacterViewModel(get()) }


    /* Picasso */
    single {
        Picasso.get()
    }

}