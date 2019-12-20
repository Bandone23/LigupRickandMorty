package com.example.liguprickandmorty.util

import android.widget.ImageView
import com.example.liguprickandmorty.R
import com.squareup.picasso.Picasso

fun getImgPicasso(picture: String, view: ImageView?) {
    if (picture.isNotEmpty()) {
        Picasso.get()
            .load(picture)
            .error(R.drawable.ic_user_default)
            .into(view)
    } else {
        Picasso.get()
            .load(R.drawable.ic_user_default)
            .error(R.drawable.ic_user_default)
            .into(view)
    }
}