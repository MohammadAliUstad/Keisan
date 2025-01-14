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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.keisan.data.CalculatorAction
import com.example.keisan.data.CalculatorOperation
import com.example.keisan.ui.components.CalculatorButton
import com.example.keisan.viewmodel.CalculatorViewModel

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class,
    ExperimentalComposeUiApi::class
)
@Composable
fun HomeScreen(navController: NavController = rememberNavController()) {
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state
    var displayText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Keisan",
                        fontSize = 26.sp,
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
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
                            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
                    )
                },
                actions = {
                    IconButton(
                        onClick = { navController.navigate("about") }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "About",
                            tint = Color.White
                        )
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(Color.Black)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(horizontal = 16.dp, vertical = 24.dp)
                        .background(
                            color = Color(0xFF1E1E1E),
                            shape = RoundedCornerShape(24.dp)
                        )
                        .padding(16.dp)
                ) {
                    BasicTextField(
                        value = displayText.ifEmpty {
                            state.number1 + (state.operation?.symbol ?: "") + state.number2
                        },
                        onValueChange = {},
                        modifier = Modifier.fillMaxSize(),
                        textStyle = LocalTextStyle.current.copy(
                            textAlign = TextAlign.End,
                            fontSize = 48.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        singleLine = false,
                        enabled = false,
                        readOnly = true
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                        .padding(bottom = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        CalculatorButton(
                            symbol = "AC",
                            width = 149,
                            height = 44,
                            modifier = Modifier.weight(2f)
                        ) {
                            viewModel.onAction(CalculatorAction.Clear)
                            displayText = ""
                        }
                        CalculatorButton(
                            symbol = "÷",
                            width = 44,
                            height = 44,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                        }
                        CalculatorButton(
                            symbol = "+",
                            width = 44,
                            height = 44,
                            isOperation = true,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        CalculatorButton(
                            symbol = "7",
                            width = 44,
                            height = 44,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(7))
                        }
                        CalculatorButton(
                            symbol = "8",
                            width = 44,
                            height = 44,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(8))
                        }
                        CalculatorButton(
                            symbol = "9",
                            width = 44,
                            height = 44,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(9))
                        }
                        CalculatorButton(
                            symbol = "x",
                            width = 44,
                            height = 44,
                            isOperation = true,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        CalculatorButton(
                            symbol = "4",
                            width = 44,
                            height = 44,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(4))
                        }
                        CalculatorButton(
                            symbol = "5",
                            width = 44,
                            height = 44,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(5))
                        }
                        CalculatorButton(
                            symbol = "6",
                            width = 44,
                            height = 44,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(6))
                        }
                        CalculatorButton(
                            symbol = "-",
                            width = 44,
                            height = 44,
                            isOperation = true,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        CalculatorButton(
                            symbol = "1",
                            width = 44,
                            height = 44,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(1))
                        }
                        CalculatorButton(
                            symbol = "2",
                            width = 44,
                            height = 44,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(2))
                        }
                        CalculatorButton(
                            symbol = "3",
                            width = 44,
                            height = 44,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(3))
                        }
                        CalculatorButton(
                            symbol = "Del",
                            width = 44,
                            height = 44,
                            isOperation = true,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Delete)
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        CalculatorButton(
                            symbol = "0",
                            width = 44,
                            height = 44,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Number(0))
                        }
                        CalculatorButton(
                            symbol = ".",
                            width = 44,
                            height = 44,
                            modifier = Modifier.weight(1f)
                        ) {
                            viewModel.onAction(CalculatorAction.Decimal)
                        }
                        CalculatorButton(
                            symbol = "=",
                            width = 149,
                            height = 44,
                            modifier = Modifier.weight(2f)
                        ) {
                            viewModel.onAction(CalculatorAction.Calculate)
                        }
                    }
                }
            }
        }
    )
}