package com.recycler.recyclerviewexample.model

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.recycler.recyclerviewexample.MainActivity
import com.recycler.recyclerviewexample.R
import com.recycler.recyclerviewexample.adapter.MainAdapter
import com.recycler.recyclerviewexample.databinding.ActivityMainBinding
import com.recycler.recyclerviewexample.dto.RCDto

class MainModel(private val cnx: Context, private val binding: ActivityMainBinding) {

    private val dataset = ArrayList<RCDto>()
    private var adapter = MainAdapter(dataset, cnx)
    private var flag = true

    fun initAdapter(){
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(cnx)
    }

    fun setData(){
        dataset.add(RCDto(R.drawable.pic1,"1", "배고프다"))
        dataset.add(RCDto(R.drawable.pic2,"2", "점심 먹으러 가고싶다"))
        dataset.add(RCDto(R.drawable.pic3,"3", "퇴근시켜줘"))
    }

    private fun addData(){
        dataset.add(RCDto(R.drawable.pic4, "4", "밥은 최고야"))
        dataset.add(RCDto(R.drawable.pic5, "5", "추가된 레이아웃"))
    }

    fun onClickEventbyNotfy(){
        binding.addButton.setOnClickListener {
            if(flag) {
                addData()
                //TODO 이미지 추가하기
                adapter.notifyItemChanged(3)
                binding.recycler.adapter = adapter
                flag = false
            }
        }
    }

    fun onClickEventbyDiffUtil(){
        binding.addButton.setOnClickListener {

        }
    }
}