package com.example.newsapp

import com.google.gson.annotations.SerializedName

data class NewsSearchResult(
//    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: List<NewsArticle>
)

data class NewsArticle(
    //Dont need seriealized if name is same
    //    val articleTitle: String,
    //    val articleDescription: String,
    @SerializedName("title") val articleTitle: String,
    @SerializedName("description") val articleDescription: String,
)