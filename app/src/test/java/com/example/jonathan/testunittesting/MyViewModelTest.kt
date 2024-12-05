package com.example.jonathan.testunittesting

import android.util.Log
import com.example.jonathan.testunittesting.viewmodel.MyViewModel
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mockStatic

class MyViewModelTest {
    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun test_getData() {
        // Mock the static Log class
        mockStatic(android.util.Log::class.java).use { logMock ->
            // Define the behavior for Log.d
            Mockito.`when`(Log.d(Mockito.anyString(), Mockito.anyString())).thenReturn(0)

            // TODO: Remove this test block:
            // Call the method
            val result = Log.d("TestTag", "TestMessage")
            // Verify the method was called
            logMock.verify { Log.d("TestTag", "TestMessage") }
            // Assert the mocked result
            assert(result == 0)

            // Actual test:
            val viewModel = MyViewModel()
            viewModel.getData()
            assertEquals("Data fetched from the repository", viewModel.data.value)
        }
    }
}
