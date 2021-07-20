package com.kenneth.week_seven_task

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel: ViewModel() {
    val items: MutableLiveData<List<Item>> = MutableLiveData()

    fun getAllItems(){
        CoroutineScope(Dispatchers.IO).launch{
            val items :List<Item> = RetrofitProvider.service.getAllItems()
            this@MainViewModel.items.postValue(items)
        }
    }
}