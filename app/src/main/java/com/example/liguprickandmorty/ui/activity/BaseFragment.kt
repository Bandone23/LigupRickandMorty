package com.example.liguprickandmorty.ui.activity

import android.net.ConnectivityManager
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.core.extension.isNetworkAvailable
import org.jetbrains.anko.support.v4.longToast
import org.koin.android.ext.android.inject

open  class BaseFragment: Fragment() {

     protected val connectionManager: ConnectivityManager by inject()


     protected fun onLoading() {} //TODO: Show loading screen
     protected fun onCancel() {} //TODO: Show cancel message
     protected fun onError(tag: String = "BaseActivity", message: String = "onError") {
         if (connectionManager.isNetworkAvailable()) {
             longToast("ya vuelves a estar conectado")
         } else {
             longToast("no hay conexion a internet")
         }
         Log.d(tag, message)
     }



 }