package com.example.jonathan.testunittesting

import android.util.Log
import com.example.jonathan.testunittesting.model.MyRepository
import com.example.jonathan.testunittesting.viewmodel.MyViewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest

class MyViewModelKoinTest : KoinTest {
    private val mockRepository: MyRepository = mockk()
    private val viewModel: MyViewModel by inject()

    @Before
    fun setUp() {
        startKoin {
            modules(
                module {
                    single { mockRepository }
                    factory { MyViewModel(get()) }
                }
            )
        }

        // Mock static methods for Log class
        mockkStatic(Log::class)
        every { Log.d(any(), any()) } returns 0 // You can return any value here for the test

        every { mockRepository.fetchData() } returns "Mocked Data"
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun test_getData() {
        viewModel.getData()

        assertEquals("Mocked Data", viewModel.data.value)
        verify { mockRepository.fetchData() }
    }
}
