package com.example.android_tbc_homework_14.repository

import com.example.android_tbc_homework_14.RetrofitInstance
import com.example.android_tbc_homework_14.model.Items
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Items> {
        return RetrofitInstance.getData().info()
    }
}