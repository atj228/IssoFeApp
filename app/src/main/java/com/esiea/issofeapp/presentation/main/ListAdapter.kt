package com.esiea.issofeapp.presentation.main

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.esiea.issofeapp.data.remote.MoviesData
import kotlinx.android.synthetic.main.row_layout.view.*


class ListAdapter(
    private val values: List<MoviesData>
    ) : RecyclerView.Adapter<ListAdapter.ListViewHolder>(){
    class ListViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.icon
        val textView1: TextView = itemView.firstLine
        val textView2: TextView = itemView.secondLine
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = values[position]
        holder.imageView.setImageResource(currentItem.imageRessource)
        holder.textView1.text = currentItem.title
        holder.textView2.text = currentItem.body
    }

    override fun getItemCount() = values.size
}