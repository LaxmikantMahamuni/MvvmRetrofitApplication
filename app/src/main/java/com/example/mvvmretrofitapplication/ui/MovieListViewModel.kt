package com.example.mvvmretrofitapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitapplication.data.model.Movie
import com.example.mvvmretrofitapplication.data.model.MovieResponse
import com.example.mvvmretrofitapplication.data.repo.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListViewModel constructor(val movieRepository: MovieRepository): ViewModel() {
    val movieList = MutableLiveData<String>()
    val errorMessage = MutableLiveData<String>()

    fun getPopularMovies() {
        val response = movieRepository.getPopularMovies()
        response.enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}