package com.example.mvvmretrofitapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitapplication.data.repo.MovieRepository

class MovieViewModelFactory constructor(val movieRepository: MovieRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
            MovieListViewModel(this.movieRepository) as T
        } else{
            throw IllegalArgumentException("ViewModel not found.")
        }
    }
}