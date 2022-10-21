package com.example.whatthefilm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_more_info.view.*
import kotlinx.android.synthetic.main.movie_item.view.movie_poster
import kotlinx.android.synthetic.main.movie_item.view.movie_title

class Adapter1(
    private val movies: List<Movie>
) : RecyclerView.Adapter<Adapter1.MovieViewHolder>(){
    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie2: Movie){
            itemView.rating.text = movie2.rating
            itemView.description.text = movie2.overview
            itemView.release_date.text = movie2.release
            itemView.movie_title.text = movie2.title
            Glide.with(itemView).load(IMAGE_BASE + movie2.poster).into(itemView.movie_poster)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_more_info, parent, false),
            )
    }

    override fun getItemCount(): Int = movies.size
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }
}

