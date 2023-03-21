package com.recycler.recyclerviewexample.model

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.recycler.recyclerviewexample.MainActivity
import com.recycler.recyclerviewexample.R
import com.recycler.recyclerviewexample.adapter.AsyncListDifferAdapter
import com.recycler.recyclerviewexample.adapter.DiffUtilAdapter
import com.recycler.recyclerviewexample.adapter.MainAdapter
import com.recycler.recyclerviewexample.databinding.ActivityMainBinding
import com.recycler.recyclerviewexample.dto.RCDto

class MainModel(private val cnx: Context, private val binding: ActivityMainBinding) {

    private val dataset = ArrayList<RCDto>()
    
    private lateinit var adapter : MainAdapter
    private lateinit var diffAdapter : DiffUtilAdapter
    private lateinit var asyncListDifferAdapter : AsyncListDifferAdapter
    
    private var flag = true
    //일반 어댑터
    fun initAdapter(){
        adapter = MainAdapter(dataset)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(cnx)
    }
    //DiffUtil을 이용한 어댑터
    fun initDiffAdapter(){
        diffAdapter = DiffUtilAdapter(ArrayList<RCDto>(dataset))
        binding.recycler.adapter = diffAdapter
        binding.recycler.layoutManager = LinearLayoutManager(cnx)
    }
    fun initAsyncListDifferAdapter(){
        asyncListDifferAdapter = AsyncListDifferAdapter(ArrayList<RCDto>(dataset))
        binding.recycler.adapter = asyncListDifferAdapter
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
    //기본 notify 메서드를 이용한 업데이트
    fun onClickEventbyNotfy(){
        binding.addButton.setOnClickListener {
            if(flag) {
                addData()
                adapter.notifyItemChanged(3)
                flag = false
            }
        }
    }
    //DiffUtil을 이용한 업데이트
    fun onClickEventbyDiffUtil(){
        binding.addButton.setOnClickListener {
            if(flag) {
                addData()
                diffAdapter.updateListItem(dataset)
                flag = false
            }
        }
    }
    //AsyncListDiffer를 이용한 업데이트
    fun onClickEventByAsyncListDiffer(){
        binding.addButton.setOnClickListener {
            if(flag){
                addData()
                asyncListDifferAdapter.submitlist(dataset)
                flag = false
            }
        }
    }
}