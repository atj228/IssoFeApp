package com.esiea.issofeapp.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.esiea.issofeapp.data.api.MovieDbInterface
import com.esiea.issofeapp.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class MovieDetailsNetworkDataSource(
    private val apiService : MovieDbInterface,
    private val compositeDisposable : CompositeDisposable
) {
    private val _networkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState

    private val _dowloadedMovieDetailsResponse = MutableLiveData<MoviesDetails>()
    val dowloadedMovieResponse: LiveData<MoviesDetails>
        get() = _dowloadedMovieDetailsResponse

    fun fetchMovieDetails(movieId: Int){
        _networkState.postValue(NetworkState.LOADING)

        try {
            compositeDisposable.add(
                apiService.getMovieDetails(movieId)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _dowloadedMovieDetailsResponse.postValue(it)
                            _networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            Log.e("MovieDetailsDataSource", it.message.toString())
                        }
                    )
            )
        }
        catch (e: Exception){
            Log.e("MovieDetailsDataSource", e.message.toString())
        }
    }
}