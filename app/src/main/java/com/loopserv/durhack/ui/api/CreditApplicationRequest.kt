package com.loopserv.durhack.ui.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreditApplicationRequest(
    val minCreditAmount: String,
    val minPaybackTime: String
)
