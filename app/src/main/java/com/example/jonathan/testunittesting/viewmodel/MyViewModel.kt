package com.example.jonathan.testunittesting.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.jonathan.testunittesting.model.MyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val TAG = "TUT: MyViewModel"

class MyViewModel : ViewModel() {
    private val repository = MyRepository()

    private val _data = MutableStateFlow("")
    val data: StateFlow<String> = _data
    
    fun getData() {
        Log.d(TAG, "getData")

        _data.value = repository.fetchData()
    }
}
