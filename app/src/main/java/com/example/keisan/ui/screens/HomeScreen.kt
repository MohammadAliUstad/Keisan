package com.example.keisan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.keisan.data.CalculatorAction
import com.example.keisan.data.CalculatorOperation
import com.example.keisan.ui.components.CalculatorButton
import com.example.keisan.viewmodel.CalculatorViewModel

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Keisan Calculator",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White
                    )
                },
                colors = topAppBarColors(
                    containerColor = Color.Black
                ),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Calculate,
                        contentDescription = "App Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(45.dp)
                            .fillMaxSize()
                    )
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)
                    .background(Color.White)
            ) {
                // Display the result box
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .background(Color.Black, shape = MaterialTheme.shapes.medium)
                        .padding(24.dp)
                ) {
                    Text(
                        text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight.Bold,
                        fontSize = 72.sp,
                        color = Color.White
                    )
                }

                // First row
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CalculatorButton(
                        symbol = "AC",
                        width = 135,
                        height = 40,
                    ) {
                        viewModel.onAction(CalculatorAction.Clear)
                    }
                    CalculatorButton(
                        symbol = "/",
                        width = 40,
                        height = 40,
                        isOperation = true,
                    ) {
                        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    }
                    CalculatorButton(
                        symbol = "+",
                        width = 40,
                        height = 40,
                        isOperation = true,
                    ) {
                        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    }
                }

                // Second row
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CalculatorButton(
                        symbol = "7",
                        width = 40,
                        height = 40,
                    ) {
                        viewModel.onAction(CalculatorAction.Number(7))
                    }
                    CalculatorButton(
                        symbol = "8",
                        width = 40,
                        height = 40,
                    ) {
                        viewModel.onAction(CalculatorAction.Number(8))
                    }
                    CalculatorButton(
                        symbol = "9",
                        width = 40,
                        height = 40,
                    ) {
                        viewModel.onAction(CalculatorAction.Number(9))
                    }
                    CalculatorButton(
                        symbol = "x",
                        width = 40,
                        height = 40,
                        isOperation = true,
                    ) {
                        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    }
                }

                // Third row
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CalculatorButton(
                        symbol = "4",
                        width = 40,
                        height = 40,
                    ) {
                        viewModel.onAction(CalculatorAction.Number(4))
                    }
                    CalculatorButton(
                        symbol = "5",
                        width = 40,
                        height = 40,
                    ) {
                        viewModel.onAction(CalculatorAction.Number(5))
                    }
                    CalculatorButton(
                        symbol = "6",
                        width = 40,
                        height = 40,
                    ) {
                        viewModel.onAction(CalculatorAction.Number(6))
                    }
                    CalculatorButton(
                        symbol = "-",
                        width = 40,
                        height = 40,
                        isOperation = true,
                    ) {
                        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    }
                }

                // Fourth row
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CalculatorButton(
                        symbol = "1",
                        width = 40,
                        height = 40,
                    ) {
                        viewModel.onAction(CalculatorAction.Number(1))
                    }
                    CalculatorButton(
                        symbol = "2",
                        width = 40,
                        height = 40,
                    ) {
                        viewModel.onAction(CalculatorAction.Number(2))
                    }
                    CalculatorButton(
                        symbol = "3",
                        width = 40,
                        height = 40,
                    ) {
                        viewModel.onAction(CalculatorAction.Number(3))
                    }
                    CalculatorButton(
                        symbol = "=",
                        width = 40,
                        height = 40,
                        isOperation = true,
                    ) {
                        viewModel.onAction(CalculatorAction.Calculate)
                    }
                }

                // Fifth row
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CalculatorButton(
                        symbol = "0",
                        width = 40,
                        height = 40,
                    ) {
                        viewModel.onAction(CalculatorAction.Number(0))
                    }
                    CalculatorButton(
                        symbol = ".",
                        width = 40,
                        height = 40,
                    ) {
                        viewModel.onAction(CalculatorAction.Decimal)
                    }
                    CalculatorButton(
                        symbol = "Del",
                        width = 135,
                        height = 40,
                    ) {
                        viewModel.onAction(CalculatorAction.Delete)
                    }
                }
            }
        }
    )
}