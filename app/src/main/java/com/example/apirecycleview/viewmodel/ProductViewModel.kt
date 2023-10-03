package com.example.apirecycleview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apirecycleview.Product
import com.example.apirecycleview.ProductInstance
import com.example.apirecycleview.ProductInterface
import com.example.apirecycleview.ProductModel
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    var productDataList = MutableLiveData<List<Product?>>()

    private var productApi = ProductInstance().getInstance().create(ProductInterface::class.java)

    fun getPro() {
        viewModelScope.launch {
            val res = productApi.getProductDetails()
//            val productModelList = listOf(res.body())

            productDataList.value = res.body()?.products
        }
    }

}