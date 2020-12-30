package com.esiea.issofeapp.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.esiea.issofeapp.data.api.MovieDbInterface
import com.esiea.issofeapp.data.remote.Movie
import com.esiea.issofeapp.data.remote.MovieDataSource
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory(
    private val apiService : MovieDbInterface,
    private val compositeDisposable: CompositeDisposable
): DataSource.Factory<Int, Movie>() {

    val moviesLiveDataSource = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService, compositeDisposable)
        moviesLiveDataSource.postValue(movieDataSource)
        return  movieDataSource
    }
}