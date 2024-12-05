package com.example.jonathan.testunittesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jonathan.testunittesting.model.MyRepository
import com.example.jonathan.testunittesting.ui.theme.TestUnitTestingTheme
import com.example.jonathan.testunittesting.view.MyView
import com.example.jonathan.testunittesting.viewmodel.MyViewModel
import com.example.jonathan.testunittesting.viewmodel.MyViewModelFactory

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Which one is better?:
        //viewModel = MyViewModel(MyRepository())
        viewModel = MyViewModelFactory(MyRepository()).create(MyViewModel::class.java)

        viewModel.getData()

        setContent {
            TestUnitTestingTheme {
                MyView(viewModel)
            }
        }
    }
}
