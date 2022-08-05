package com.example.android_tbc_homework_14.api

import com.example.android_tbc_homework_14.model.Items
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {

    @GET("v3/f4864c66-ee04-4e7f-88a2-2fbd912ca5ab")
    suspend fun info(): Response<Items>


}