package com.loopserv.durhack.ui.api

import androidx.lifecycle.LiveData
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object API {

    val client by lazy {
        Retrofit.Builder()
            .baseUrl("https://durhack2019-259919.appspot.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(apiservice::class.java)
    }
}