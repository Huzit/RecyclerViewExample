package com.recycler.recyclerviewexample.callback

import androidx.recyclerview.widget.DiffUtil
import com.recycler.recyclerviewexample.dto.RCDto

class DiffUtilCallBack(private val mOldItem: List<RCDto>, private val mNewItem: List<RCDto>): DiffUtil.Callback() {
    override fun getOldListSize(): Int = mOldItem.size
    
    override fun getNewListSize(): Int = mNewItem.size
    
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        mOldItem[oldItemPosition].title == mNewItem[newItemPosition].title
    
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        mOldItem[oldItemPosition].content == mNewItem[newItemPosition].content
    
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}