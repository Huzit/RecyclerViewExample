package com.recycler.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.recycler.recyclerviewexample.adapter.MainAdapter
import com.recycler.recyclerviewexample.databinding.ActivityMainBinding
import com.recycler.recyclerviewexample.dto.RCDto
import com.recycler.recyclerviewexample.model.MainModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainModel: MainModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding()
        initRecycler()
        setOnClick()
    }

    private fun viewBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        mainModel = MainModel(this, binding)
        setContentView(binding.root)
    }

    private fun initRecycler(){
        mainModel.apply {
            initAdapter()
            setData()
        }
    }

    private fun setOnClick(){
        mainModel.onClickEventbyNotfy()
    }
}