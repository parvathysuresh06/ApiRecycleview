package com.example.apirecycleview

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductInstance {

    private val baseUrl="https://dummyjson.com/"

    fun  getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}