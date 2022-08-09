package com.example.android_tbc_homework_14

import com.example.android_tbc_homework_14.api.MyApi
import com.example.android_tbc_homework_14.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getData() = retrofit.create(MyApi::class.java)
}
