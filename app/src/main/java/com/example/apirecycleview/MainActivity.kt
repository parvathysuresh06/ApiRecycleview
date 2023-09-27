package com.example.apirecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apirecycleview.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel: ProductViewModel
    private lateinit var adapter: AdapterClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerview = findViewById<RecyclerView>(R.id.recycleView)
        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener {
            viewmodel.apply {
                getPro()
            }
        }
        recyclerview.layoutManager = LinearLayoutManager(this)
        viewmodel= ViewModelProvider(this)[ProductViewModel::class.java]


        viewmodel.productDataList.observe(this) { result ->
            val adapter = AdapterClass(result ?: emptyList())
            recyclerview.adapter = adapter
            adapter.notifyDataSetChanged()
        }


    }




}