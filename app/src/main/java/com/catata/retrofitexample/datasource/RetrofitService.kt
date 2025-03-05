package com.catata.retrofitexample.datasource

import com.catata.retrofitexample.datasource.model.APIResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
    // If the value to pass is a parameter: ?parameter=value
    @GET("character/")
    suspend fun getCharactersByName(
        @Query("name") name: String
    ): APIResponse

    // If the value to pass is part of the path
    @GET("character/{name}")
    suspend fun getCharactersByNamePath(
        @Path("name") name: String
    ): APIResponse
}
