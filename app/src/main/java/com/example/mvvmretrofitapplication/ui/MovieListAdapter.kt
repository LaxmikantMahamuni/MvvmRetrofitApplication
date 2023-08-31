package com.example.mvvmretrofitapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmretrofitapplication.R
import com.example.mvvmretrofitapplication.data.model.Movie
import com.example.mvvmretrofitapplication.databinding.ActivityMainBinding
import com.example.mvvmretrofitapplication.databinding.LayoutRvItemBinding

class MovieListAdapter : RecyclerView.Adapter<MovieViewHolder>() {
    var movieList = mutableListOf<Movie>()

    fun setMovieData(list: List<Movie>) {
        this.movieList = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutRvItemBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.movieTitle.text = movie.title
        Glide.with(holder.itemView.context).load(movie.posterPath).placeholder(R.drawable.placeholder)
            .into(holder.binding.moviePoster)
    }
}

class MovieViewHolder (val binding: LayoutRvItemBinding): RecyclerView.ViewHolder(binding.root){}
