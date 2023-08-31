package com.example.mvvmretrofitapplication.data.network

import com.example.mvvmretrofitapplication.data.model.MovieResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

interface RetrofitService {

    @GET("3/movie/popular")
    fun getPopularMovies(@Header("Authorization") authorization: String): Call<String>

    companion object{
        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService {
            if(retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.themoviedb.org/")
                    .build()

                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

        const val API_KEY = "dabc075c4f858529a867c5eace88cb43"
        const val ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkYWJjMDc1YzRmODU4NTI5YTg2N2M1ZWFjZTg4Y2I0MyIsInN1YiI6IjY0ZWIxY2FiYzVjMWVmMDBhZDNlMjkyOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.NTrq00J5L8BhDl3o55QAflTzAm6yjY6E3C4VmfnXGaY"
    }
}