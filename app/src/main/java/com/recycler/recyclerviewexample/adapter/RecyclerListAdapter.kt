package com.recycler.recyclerviewexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.recycler.recyclerviewexample.R
import com.recycler.recyclerviewexample.callback.DiffUtilItemCallBack
import com.recycler.recyclerviewexample.databinding.ViewholderMainBinding
import com.recycler.recyclerviewexample.dto.RCDto

class RecyclerListAdapter: ListAdapter<RCDto, RecyclerListAdapter.ListAdapterViewHolder>(cb) {
    companion object{
        val cb = DiffUtilItemCallBack()
    }
    inner class ListAdapterViewHolder(val binding: ViewholderMainBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(rcDto: RCDto){
            Glide.with(itemView.context).load(rcDto.image).into(binding.vhImage)
            binding.vhTitle.text = rcDto.title
            binding.vhContent.text = rcDto.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterViewHolder = ListAdapterViewHolder(
        ViewholderMainBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ListAdapterViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}