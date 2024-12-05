package com.example.jonathan.testunittesting

import android.util.Log
import com.example.jonathan.testunittesting.viewmodel.MyViewModel
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

        // Arrange
        every { Log.d(any(), any()) } returns 0 // You can return any value here for the test
    }

    @After
    fun tearDown() {
    }

    @Test
    fun test_getData() {
        val viewModel = MyViewModel()
        viewModel.getData()
        assertEquals("Data fetched from the repository", viewModel.data.value)
    }
}
