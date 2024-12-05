package com.example.jonathan.testunittesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jonathan.testunittesting.model.MyRepository
import com.example.jonathan.testunittesting.ui.theme.TestUnitTestingTheme
import com.example.jonathan.testunittesting.view.MyView
import com.example.jonathan.testunittesting.viewmodel.MyViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Any concerns about not using ViewModelProvider?
        viewModel = MyViewModel(MyRepository())
        viewModel.getData()

        setContent {
            TestUnitTestingTheme {
                MyView(viewModel)
            }
        }
    }
}
