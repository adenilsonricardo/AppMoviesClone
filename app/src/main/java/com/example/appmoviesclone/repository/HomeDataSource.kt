package com.example.appmoviesclone.repository

import com.example.appmoviesclone.network.ErrorResponse
import com.example.appmoviesclone.network.NetworkResponse
import com.example.appmoviesclone.network.model.dto.MovieDTO
import kotlinx.coroutines.CoroutineDispatcher

interface HomeDataSource {
    suspend fun getListsOfMovies(dispatcher: CoroutineDispatcher, homeResultCallback:(result: NetworkResponse<List<List<MovieDTO>>, ErrorResponse>) -> Unit)
}