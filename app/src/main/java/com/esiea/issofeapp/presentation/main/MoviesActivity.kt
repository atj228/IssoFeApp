package com.esiea.issofeapp.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.esiea.issofeapp.R
import com.esiea.issofeapp.data.remote.MoviesData
import java.util.*


class MoviesActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView? = null
    private val mAdapter: RecyclerView.Adapter<*>? = null
    private val layoutManager: RecyclerView.LayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
    }

    private fun generateMoviesList(size: Int): List<MoviesData>{
        val list = ArrayList<MoviesData>()

        for(i in 0 until size){
           val item = MoviesData()
        }
    }
}