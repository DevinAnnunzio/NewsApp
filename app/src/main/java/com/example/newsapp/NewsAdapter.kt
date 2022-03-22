package com.example.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(val context: Context, val newsArticles: List<NewsArticle>):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsArticle = newsArticles[position]
        holder.bind(newsArticle)
    }

    override fun getItemCount() = newsArticles.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(article: NewsArticle) {
            var title = itemView.findViewById<TextView>(R.id.articleTitleTV)
            var desc = itemView.findViewById<TextView>(R.id.newsDescTV)
            title.text = article.articleTitle
            desc.text = article.articleDescription

        }

    }
}