package com.loopserv.durhack.ui.api

import retrofit2.http.Body
import retrofit2.http.POST

interface apiservice {
    @POST("/api/create_user")
    suspend fun getUser(@Body data: FirebaseDto): User?

    @POST("/api/add_application")
    suspend fun createApplication(@Body data: CreditApplicationRequest)
}