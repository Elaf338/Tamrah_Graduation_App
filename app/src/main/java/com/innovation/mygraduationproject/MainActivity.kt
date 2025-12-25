package com.innovation.mygraduationproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.innovation.mygraduationproject.navigation.AppNavigator
import com.innovation.mygraduationproject.ui.theme.TamrahTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TamrahTheme {
                AppNavigator()
            }
        }
    }
}