package com.esiea.issofeapp.data.repository

import androidx.lifecycle.LiveData
import com.esiea.issofeapp.data.api.MovieDbInterface
import com.esiea.issofeapp.data.remote.MovieDetailsNetworkDataSource
import com.esiea.issofeapp.data.remote.MoviesDetails
import io.reactivex.disposables.CompositeDisposable

class MoviesDetailsRepository(
    private val apiService : MovieDbInterface
) {
    lateinit var movieDetailsNetworkDataSource : MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MoviesDetails>{
        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.dowloadedMovieResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState>{
        return movieDetailsNetworkDataSource.networkState
    }
}