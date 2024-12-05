package com.example.jonathan.testunittesting.viewmodel

import android.util.Log
import com.example.jonathan.testunittesting.model.MyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val TAG = "TUT: MyViewModel"

// TODO: Any concerns on not using ViewModel?
class MyViewModel(private val repository: MyRepository) {
    private val _data = MutableStateFlow("Default data........")
    val data: StateFlow<String> = _data
    
    fun getData() {
        Log.d(TAG, "getData")

        _data.value = repository.fetchData()
    }
}
