package com.loopserv.durhack.ui.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreditApplication(
    val name: String,
    val address: String,
    val minCreditAmount: String,
    val minPaybackTime: String,
    val dob: String,
    val howWillUse: String,
    val reason: String,
    val howWillRepay: String,
    val state: String
) {
    companion object {
        const val STATE_PENDING = "pending"
    }
}
