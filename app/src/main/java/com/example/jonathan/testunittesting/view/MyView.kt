package com.example.jonathan.testunittesting.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.jonathan.testunittesting.viewmodel.MyViewModel

@Composable
fun MyView(viewModel: MyViewModel) {
    val dataState by viewModel.data.collectAsState() // Collect as state

    Text(
        text = dataState
    )
}
