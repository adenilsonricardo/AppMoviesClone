package com.example.appmoviesclone.ui


import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.appmoviesclone.network.TmdbApi
import com.example.appmoviesclone.network.model.dto.MovieResponseDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeViewModel @Inject constructor(val tmdbApi: TmdbApi) : ViewModel() {
    fun getTrending() {
        tmdbApi.getTrending("pt-BR", 1)?.enqueue(object : Callback<MovieResponseDTO> {
            override fun onFailure(call: retrofit2.Call<MovieResponseDTO>, t: Throwable) {
                Log.d("meuteste", "onFailure")
            }
            override fun onResponse(
                call: Call<MovieResponseDTO>,
                response: Response<MovieResponseDTO>
            ) {
                if (response.isSuccessful){
                }
            }
        })
    }
}