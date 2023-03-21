package com.recycler.recyclerviewexample.adapter

import androidx.recyclerview.widget.DiffUtil
import com.recycler.recyclerviewexample.dto.RCDto

class DiffUtilItemCallBack: DiffUtil.ItemCallback<RCDto>() {
    override fun areItemsTheSame(oldItem: RCDto, newItem: RCDto): Boolean = oldItem === newItem

    override fun areContentsTheSame(oldItem: RCDto, newItem: RCDto) = oldItem == newItem

    override fun getChangePayload(oldItem: RCDto, newItem: RCDto): Any? {
        return super.getChangePayload(oldItem, newItem)
    }
}