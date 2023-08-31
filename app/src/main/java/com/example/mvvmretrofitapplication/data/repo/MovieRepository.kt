package com.example.mvvmretrofitapplication.data.repo

import com.example.mvvmretrofitapplication.data.network.RetrofitService

class MovieRepository constructor(val retrofitService: RetrofitService) {
    fun getPopularMovies() = retrofitService
        .getPopularMovies(
            RetrofitService.ACCESS_TOKEN)
}