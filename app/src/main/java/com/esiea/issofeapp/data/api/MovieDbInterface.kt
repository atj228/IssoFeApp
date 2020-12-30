package com.esiea.issofeapp.data.api

import com.esiea.issofeapp.data.remote.MovieResponse
import com.esiea.issofeapp.data.remote.MoviesDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDbInterface {
    //https://api.themoviedb.org/3/movie/577922?api_key=b88113217c8b8785a635efae5654aa5a
    //https://api.themoviedb.org/3/movie/popular?api_key=b88113217c8b8785a635efae5654aa5a
    //https://api.themoviedb.org/3/

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MoviesDetails>
}