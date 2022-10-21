package com.example.whatthefilm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.movie_item.view.*


class Adapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<Adapter.MovieViewHolder>(){
    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie2: Movie){
            itemView.movie_title.text = movie2.title
            Glide.with(itemView).load(IMAGE_BASE + movie2.poster).into(itemView.movie_poster)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false),
        )

    }
    override fun getItemCount(): Int = movies.size
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }

}
















