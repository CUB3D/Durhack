package com.loopserv.durhack.ui.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val applications: List<CreditApplication>
)