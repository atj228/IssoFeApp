package com.esiea.issofeapp.data.api

import com.esiea.issofeapp.data.remote.MovieResponseSecond
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=b88113217c8b8785a635efae5654aa5a")
    fun getMovieList(): Call<MovieResponseSecond>
}