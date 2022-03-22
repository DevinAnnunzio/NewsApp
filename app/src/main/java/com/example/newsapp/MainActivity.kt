package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "MainActivity"
private const val BASE_URL = "https://newsapi.org/v2/"
private const val API_KEY = "f3212e29331d4d46938c3b2aefb4d8e0"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val newsRV = findViewById<RecyclerView>(R.id.newsRV)
        val newsArticles = mutableListOf<NewsArticle>()
        val adapter = NewsAdapter(this, newsArticles)
        newsRV.adapter = adapter
        newsRV.layoutManager = LinearLayoutManager(this)


        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

        val newsService = retrofit.create(NewsService::class.java)
        newsService.searchNews("us", API_KEY).enqueue(object : Callback<NewsSearchResult> {
            override fun onResponse(call: Call<NewsSearchResult>, response: Response<NewsSearchResult>) {
                Log.i(TAG, "On response $response")
                //Check body of response validation
                val body = response.body()
                if(body == null){
                    Log.w(TAG, "SOMETHING IS WRONG GETTING BODY DATA ")
                    return
                }
                newsArticles.addAll(body.articles)
                adapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<NewsSearchResult>, t: Throwable) {
                Log.i(TAG, "On failure $t")
            }

        })

    }

//status total results articles
}