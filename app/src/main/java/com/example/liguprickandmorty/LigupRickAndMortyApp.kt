package com.example.liguprickandmorty

import android.app.Application
import com.example.liguprickandmorty.di.appModule
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


const val URL_BASE_API = "https://rickandmortyapi.com/api/"
open class LigupRickAndMortyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        AndroidThreeTen.init(this)
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@LigupRickAndMortyApp)
            modules(listOf(appModule))
        }
    }
}