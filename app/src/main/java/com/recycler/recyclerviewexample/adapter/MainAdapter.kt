package com.recycler.recyclerviewexample.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.recycler.recyclerviewexample.R
import com.recycler.recyclerviewexample.databinding.ViewholderMainBinding
import com.recycler.recyclerviewexample.dto.RCDto
import kotlin.coroutines.coroutineContext

class MainAdapter(val dataset: ArrayList<RCDto>, val cnx: Context): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(view: View): RecyclerView.ViewHolder(view){
        var binding: ViewholderMainBinding
        init {
            binding = ViewholderMainBinding.bind(view)
        }
    }
    //뷰 그룹의 뷰를 뷰 홀더를 넣어줌
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_main, parent, false)
        return MainViewHolder(view)
    }
    //뷰 홀더에 데이터 셋팅
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        Log.d(javaClass.simpleName, dataset[position].toString())
        Glide.with(holder.itemView.context).load(dataset[position].image).into(holder.binding.vhImage)
        holder.binding.vhTitle.text = dataset[position].title
        holder.binding.vhContent.text = dataset[position].content
    }

    override fun getItemCount() = dataset.size
}
