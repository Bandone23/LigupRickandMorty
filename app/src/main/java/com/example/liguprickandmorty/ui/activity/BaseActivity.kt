package com.example.liguprickandmorty.ui.activity

import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.core.extension.isNetworkAvailable
import com.example.liguprickandmorty.R
import org.jetbrains.anko.longToast
import org.koin.android.ext.android.inject

open class BaseActivity: AppCompatActivity() {
    private val fm: FragmentManager = supportFragmentManager
    protected var active: Fragment? = null
    private val connectionManager: ConnectivityManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun onError(tag: String = "BaseActivity", message: String = "onError") {
        if (connectionManager.isNetworkAvailable()) {
            longToast("ya vuelves a estar conectado")
        } else {
            longToast("no hay conexion a internet")
        }
        Log.d(tag, message)
    }

    protected fun addFragment(fragment: Fragment, tag: String) {
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.container, fragment, tag)
        transaction.commit()
        active = fragment
    }

}