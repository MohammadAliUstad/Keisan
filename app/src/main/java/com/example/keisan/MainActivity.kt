package com.example.keisan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.keisan.ui.screens.AboutScreen
import com.example.keisan.ui.screens.HomeScreen
import com.example.keisan.ui.theme.KeisanTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost

@Suppress("DEPRECATION")
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { true }
        Thread.sleep(300)
        splashScreen.setKeepOnScreenCondition { false }
        setContent {
            KeisanTheme {
                val navController = rememberNavController()
                AnimatedNavHost(
                    navController = navController,
                    startDestination = "home",
                    enterTransition = { defaultEnterTransition() },
                    exitTransition = { defaultExitTransition() },
                    popEnterTransition = { defaultPopEnterTransition() },
                    popExitTransition = { defaultPopExitTransition() }
                ) {
                    composable("home") {
                        HomeScreen(navController)
                    }
                    composable("about") {
                        AboutScreen(navController)
                    }
                }
            }
        }
    }
}

private fun defaultEnterTransition(): EnterTransition {
    return slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(300)) +
            fadeIn(animationSpec = tween(300))
}

private fun defaultExitTransition(): ExitTransition {
    return slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(300)) +
            fadeOut(animationSpec = tween(300))
}

private fun defaultPopEnterTransition(): EnterTransition {
    return slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(300)) +
            fadeIn(animationSpec = tween(300))
}

private fun defaultPopExitTransition(): ExitTransition {
    return slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(300)) +
            fadeOut(animationSpec = tween(300))
}