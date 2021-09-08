package com.example.appmoviesclone.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmoviesclone.R
import com.example.appmoviesclone.network.model.dto.MovieDTO

class ListsOfMoviesAdapter (val context: Context, val lists: List<List<MovieDTO>>)
    : RecyclerView.Adapter<ListsOfMoviesAdapter.MovieListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_rv_movies, parent, false)
        return MovieListHolder(view)
    }
    override fun getItemCount(): Int = lists.size
    override fun onBindViewHolder(holder: MovieListHolder, position: Int) {
        holder.title.text = when(position){
            0 -> "Trending"
            1 -> "Upcoming"
            2 -> "Popular"
            3 -> "Top Rated"
            else -> "Movies"
        }
        holder.movies.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.movies.adapter = MovieAdapter(context, lists[position])
    }
    class MovieListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tv_movies_title)
        var movies: RecyclerView = itemView.findViewById(R.id.rv_movies)
    }
}

