package com.example.appmoviesclone.ui

import com.example.appmoviesclone.AppConstants
import com.example.appmoviesclone.R
import com.squareup.picasso.Picasso

package com.example.appmoviesclone.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmoviesclone.network.model.dto.MovieDTO

class MovieAdapter (val context: Context, val movies: List<MovieDTO>)
    : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_movie, parent, false)
        return MovieHolder(view)
    }
    override fun getItemCount(): Int = movies.size
    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        movies.elementAt(position).apply {
            Picasso.get()
                .load("${AppConstants.TMDB_IMAGE_BASE_URL_W185}${poster_path}")
        }
    }
    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var title = itemView.cv_movie
        private var movies = itemView.iv_movie_poster
    }
}

