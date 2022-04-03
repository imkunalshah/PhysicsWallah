package com.kunal.physicswallah.data.network

import com.kunal.physicswallah.data.network.models.Data
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {

    @GET("data/users")
    suspend fun getData(): Response<List<Data>>

}