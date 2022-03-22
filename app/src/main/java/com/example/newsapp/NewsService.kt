package com.example.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    fun searchNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ) : Call<NewsSearchResult>

}
//country=us&apiKey=f3212e29331d4d46938c3b2aefb4d8e0