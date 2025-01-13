package com.example.keisan.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DensityMedium
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalComposeUiApi
@Composable
fun CalculatorButton(
    symbol: String,
    width: Int,
    height: Int,
    modifier: Modifier = Modifier,
    isOperation: Boolean = false,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(CircleShape)  // Move clip before clickable
            .background(Color(0xFF2D2D2D), shape = CircleShape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = true), // Add ripple indication
                onClick = onClick
            )
            .padding(20.dp)
            .size(width = width.dp, height = height.dp)
    ) {
        if (isOperation) {
            val icon = when (symbol) {
                "+" -> Icons.Filled.Add
                "-" -> Icons.Filled.Remove
                "x" -> Icons.Filled.Close
                "/" -> Icons.Filled.DensityMedium
                "=" -> Icons.Filled.Done
                "AC" -> Icons.Filled.Clear
                else -> null
            }
            icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = symbol,
                    tint = Color.White
                )
            }
        } else {
            Text(
                text = symbol,
                fontSize = 36.sp,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}