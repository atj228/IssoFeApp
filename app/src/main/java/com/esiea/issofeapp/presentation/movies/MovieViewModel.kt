package com.esiea.issofeapp.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.esiea.issofeapp.data.remote.Movie
import com.esiea.issofeapp.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class MovieViewModel(
    private val movieRepository: MoviePagedListRepository
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val moviePagedList : LiveData<PagedList<Movie>> by lazy {
        movieRepository.fetchLiveMoviePagedList(compositeDisposable)
    }

    val networkState : LiveData<NetworkState> by lazy {
        movieRepository.getNetworkState()
    }

    fun listIsEmpty(): Boolean{
        return moviePagedList.value?.isEmpty() ?: true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}