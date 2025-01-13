package com.example.keisan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.keisan.ui.screens.HomeScreen
import com.example.keisan.ui.theme.KeisanTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { true }
        Thread.sleep(300)
        splashScreen.setKeepOnScreenCondition { false }
        setContent {
            KeisanTheme {
                HomeScreen()
            }
        }
    }
}