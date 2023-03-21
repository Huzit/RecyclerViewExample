package com.recycler.recyclerviewexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.recycler.recyclerviewexample.R
import com.recycler.recyclerviewexample.databinding.ViewholderMainBinding
import com.recycler.recyclerviewexample.dto.RCDto

//가장 큰 차이점 생성자 프로퍼티가 필요없어짐
class AsyncListDifferAdapter: RecyclerView.Adapter<AsyncListDifferAdapter.MainViewHolder>() {
    //AsyncListDiffer 정의
    private var mDiffer: AsyncListDiffer<RCDto> = AsyncListDiffer(this, DiffUtilItemCallBack())

    inner class MainViewHolder(view: View): RecyclerView.ViewHolder(view){
        var binding: ViewholderMainBinding
        init {
            binding = ViewholderMainBinding.bind(view)
        }

        fun bind(rcDto: RCDto){
            Glide.with(itemView.context)
                .load(rcDto.image)
                .into(binding.vhImage)
            binding.apply {
                vhTitle.text = rcDto.title
                vhContent.text = rcDto.content
            }
        }
    }
    //리스트 변경
    fun submitList(data: ArrayList<RCDto>) = mDiffer.submitList(data)
    //아이템 가져옴
    private fun getItem(position: Int): RCDto = mDiffer.currentList[position]

    //뷰 그룹의 뷰를 뷰 홀더를 넣어줌
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_main, parent, false)
        return MainViewHolder(view)
    }
    //뷰 홀더에 데이터 셋팅
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount() = mDiffer.currentList.size
}
