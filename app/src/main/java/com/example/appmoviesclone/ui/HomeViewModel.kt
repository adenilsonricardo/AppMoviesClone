package com.example.appmoviesclone.ui

import android.telecom.Call
import androidx.lifecycle.ViewModel
import com.example.appmoviesclone.network.TmdbApi
import com.example.appmoviesclone.network.model.dto.MovieResponseDTO
import javax.inject.Inject
import javax.security.auth.callback.Callback

class HomeViewModel @Inject constructor(tmdbApi: TmdbApi) : ViewModel() {
    fun getTrending() {
        TmdbApi.getTrending("pt-BR", 1).enqueue(object : Callback<MovieResponseDTO>){
            override fun onFailure(call: Call<MovieResponseDTO, t:Throwable>)
        }
    }

}