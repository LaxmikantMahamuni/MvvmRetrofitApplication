package com.example.mvvmretrofitapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmretrofitapplication.R
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitapplication.data.network.RetrofitService
import com.example.mvvmretrofitapplication.data.repo.MovieRepository
import com.example.mvvmretrofitapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MovieListViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = MovieListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get viewmodel instance using MyViewModelFactory
        viewModel =
            ViewModelProvider(this, MovieViewModelFactory(MovieRepository(retrofitService))).get(
                MovieListViewModel::class.java
            )

        //set recyclerview adapter
        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this, Observer {
            if(it != null) {
                Log.d(TAG, "movieList: $it")
//                adapter.setMovieData(it)
            } else {
                Log.d(TAG, "movieList: Null")
            }
        })

        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        viewModel.getPopularMovies()
    }
}