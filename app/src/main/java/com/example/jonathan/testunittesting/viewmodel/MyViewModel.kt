package com.example.jonathan.testunittesting.viewmodel

import androidx.lifecycle.ViewModel
import com.example.jonathan.testunittesting.model.MyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyViewModel : ViewModel() {
    private val repository = MyRepository()

    private val _data = MutableStateFlow("")
    val data: StateFlow<String> = _data
    
    fun getData() {
        _data.value = repository.fetchData()
    }
}
