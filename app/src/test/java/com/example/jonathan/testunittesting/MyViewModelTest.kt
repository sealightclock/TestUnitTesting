package com.example.jonathan.testunittesting

import android.util.Log
import com.example.jonathan.testunittesting.model.MyRepository
import com.example.jonathan.testunittesting.viewmodel.MyViewModel
import com.example.jonathan.testunittesting.viewmodel.MyViewModelFactory
import io.mockk.every
import io.mockk.mockkStatic
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MyViewModelTest {
    @Before
    fun setUp() {
        // Mock static methods for Log class
        mockkStatic(Log::class)
        every { Log.d(any(), any()) } returns 0 // You can return any value here for the test
    }

    @After
    fun tearDown() {
    }

    @Test
    fun test_getData() {
        // TODO: Which way is better?:
        //val viewModel = MyViewModel(MyRepository())
        val viewModel = MyViewModelFactory(MyRepository()).create(MyViewModel::class.java)

        viewModel.getData()
        assertEquals("Data fetched from the repository", viewModel.data.value)
    }
}
