package com.example.apirecycleview

import retrofit2.Response
import retrofit2.http.GET

interface ProductInterface {
    @GET("/products")
    suspend fun getProductDetails(): Response<ProductModel>
}