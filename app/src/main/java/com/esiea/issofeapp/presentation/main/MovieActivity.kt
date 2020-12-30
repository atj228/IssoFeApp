package com.esiea.issofeapp.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.esiea.issofeapp.R
import com.esiea.issofeapp.data.api.MovieApiInterface
import com.esiea.issofeapp.data.api.MovieApiService
import com.esiea.issofeapp.data.remote.MovieResponseSecond
import com.esiea.issofeapp.data.remote.MovieSecond
import kotlinx.android.synthetic.main.activity_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies : List<MovieSecond> ->
            rv_movies_list.adapter = MovieAdapter(movies)
        }
    }

    private fun getMovieData(callback: (List<MovieSecond>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponseSecond> {
            override fun onFailure(call: Call<MovieResponseSecond>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponseSecond>, response: Response<MovieResponseSecond>) {
                return callback(response.body()!!.movies)
            }

        })
    }
}