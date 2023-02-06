package com.walletconnect.codingchallenge.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.walletconnect.codingchallenge.ui.theme.CodingChallengeTheme
import com.walletconnect.codingchallenge.util.assetManager

class ClothingActivity : ComponentActivity() {
    private val viewModel: ClothingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupDI()

        setContent {
            CodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                }
            }
        }
    }

    private fun setupDI() {
        assetManager = assets!!
    }
}