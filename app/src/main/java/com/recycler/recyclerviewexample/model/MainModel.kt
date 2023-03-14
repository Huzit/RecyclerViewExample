package com.recycler.recyclerviewexample.model

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.recycler.recyclerviewexample.MainActivity
import com.recycler.recyclerviewexample.adapter.MainAdapter
import com.recycler.recyclerviewexample.databinding.ActivityMainBinding
import com.recycler.recyclerviewexample.dto.RCDto

class MainModel(private val cnx: Context, private val binding: ActivityMainBinding) {

    companion object{
        val dataset = ArrayList<RCDto>()
        var adapter = MainAdapter(dataset)
    }
    private var flag = true

    fun initAdapter(){
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(cnx)
    }

    fun setData(){
        dataset.add(RCDto("1반", "배고프다"))
        dataset.add(RCDto("2반", "점심 먹으러 가고싶다"))
        dataset.add(RCDto("3반", "퇴근시켜줘"))
    }

    private fun addData(){
        dataset.add(RCDto("4번", "밥은 최고야"))
        dataset.add(RCDto("5번", "추가된 레이아웃"))
    }

    fun onClickEventbyNotfy(){
        addData()
        binding.addButton.setOnClickListener {
            //TODO 이미지 추가하기
            adapter.notifyItemChanged(3)
            binding.recycler.adapter = adapter
        }
    }

    fun onClickEventbyDiffUtil(){
        binding.addButton.setOnClickListener {

        }
    }
}