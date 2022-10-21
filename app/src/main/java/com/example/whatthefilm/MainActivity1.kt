package com.example.whatthefilm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        rv_movies_list3.layoutManager = LinearLayoutManager(this)
        rv_movies_list3.setHasFixedSize(true)
        val buttonClick = findViewById<Button>(R.id.button3)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        getMovieData { movies : List<Movie> ->
            rv_movies_list3.adapter = Adapter1(movies)
        }
    }
    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = ApiService.getInstance().create(ApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<com.example.whatthefilm.Response> {
            override fun onFailure(call: Call<com.example.whatthefilm.Response>, t: Throwable) {
            }
            override fun onResponse(call: Call<com.example.whatthefilm.Response>, response: Response<com.example.whatthefilm.Response>) {
                return callback(response.body()!!.movies)
            }

        })
    }
}