package com.esiea.issofeapp.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.esiea.issofeapp.data.remote.MoviesDetails
import com.esiea.issofeapp.data.repository.MoviesDetailsRepository
import com.esiea.issofeapp.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class SingleMovieViewModel(
    private val movieRepository: MoviesDetailsRepository,
    movieId : Int
): ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val movieDetails : LiveData<MoviesDetails> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable,movieId)
    }

    val networkState : LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared(){
        super.onCleared()
        compositeDisposable.dispose()
    }

}