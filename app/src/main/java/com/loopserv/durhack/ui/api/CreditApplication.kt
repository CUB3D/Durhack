package com.loopserv.durhack.ui.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreditApplication(
    val requestedValue: String,
    val minimumPaybackTime: String
)
