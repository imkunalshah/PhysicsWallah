package com.kunal.physicswallah.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kunal.physicswallah.data.network.MyApi
import com.kunal.physicswallah.data.network.SafeApiRequest
import com.kunal.physicswallah.data.network.models.Data

class DataRepository(
    private val api: MyApi
) : SafeApiRequest() {

    private val dataList = MutableLiveData<List<Data>>()

    suspend fun fetchData(): MutableLiveData<List<Data>> {
        getData()
        return dataList
    }

    private suspend fun getData() {
        val response = apiRequest { api.getData() }
        dataList.value = response
    }

}