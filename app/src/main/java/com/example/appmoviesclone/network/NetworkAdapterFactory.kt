package com.example.appmoviesclone.network

import com.example.appmoviesclone.network.model.dto.MovieResponseDTO
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Parameter
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class NetworkAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        // Call<NetworkResponse<MovieResponseDTO, ErrorResponse>>
        if (Call::class.java != getRawType(returnType)) {
            return null
        }
        check(returnType is ParameterizedType) {
            "return type must be parameterized as Call<NetworkResponse<anything>>"
        }
        val responseType = getParameterUpperBound(0,returnType)

        if (getRawType(responseType) != NetworkResponse::class.java){
            return null
        }
        check(responseType is ParameterizedType) {
            "return type must be parameterized as Call<NetworkResponse<anything>>"
        }
        val successBodyType: Type = getParameterUpperBound(0,responseType)
        val errorBodytype: Type = getParameterUpperBound(1,responseType)

        val errorBodyConverter =
            retrofit.nextResponseBodyConverter<Any>(null, errorBodytype, annotations)

        return NetworkResponseAdapter<Any, Any>(successBodyType, errorBodyConverter)
    }
}