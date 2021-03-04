    package com.kenjoel.searchapp.api

import com.kenjoel.searchapp.BuildConfig
import com.kenjoel.searchapp.unsplash_folder.Unsplash
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface UnsplashApi {

    companion object{
        const val BASE_URL = "https://api.unsplash.com/"
        const val client_id = BuildConfig.unsplash_access_key;
    }

    @Headers("Accept-Version: 1", "Authorization: client-ID$client_id")
    @GET("search/photos")
    suspend fun getImages(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): UnsplashApiResponse
}