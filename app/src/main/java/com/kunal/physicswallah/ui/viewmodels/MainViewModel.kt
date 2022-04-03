package com.kunal.physicswallah.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kunal.physicswallah.data.network.models.Data
import com.kunal.physicswallah.data.repositories.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val repository: DataRepository
) : ViewModel() {

    private var _data = MutableLiveData<List<Data>>()
    val data: LiveData<List<Data>> = _data

    fun getData() {
        viewModelScope.launch(Dispatchers.Main) {
            val response = repository.fetchData()
            _data.postValue(response.value)
        }
    }

}