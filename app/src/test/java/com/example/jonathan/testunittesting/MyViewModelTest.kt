package com.example.jonathan.testunittesting

import com.example.jonathan.testunittesting.viewmodel.MyViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class MyViewModelTest {
    @Test
    fun test_getData() {
        val viewModel = MyViewModel()
        viewModel.getData()

        assertEquals("Data fetched from the repository", viewModel.data.value)
    }
}
