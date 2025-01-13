package com.example.keisan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
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
                        text = "Keisan",
                        fontSize = 30.sp,
                        style = MaterialTheme.typography.headlineSmall,
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
                            .padding(start = 16.dp)
                            .size(45.dp)
                    )
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(Color.Black)
                        .padding(24.dp)
                ) {
                    Text(
                        text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight.Bold,
                        fontSize = 72.sp,
                        color = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(horizontal = 8.dp)
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

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(horizontal = 8.dp)
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

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(horizontal = 8.dp)
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

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(horizontal = 8.dp)
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

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(horizontal = 8.dp)
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
        }
    )
}