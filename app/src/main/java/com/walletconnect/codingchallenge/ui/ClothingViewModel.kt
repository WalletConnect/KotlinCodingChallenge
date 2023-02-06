package com.walletconnect.codingchallenge.ui

import androidx.lifecycle.ViewModel
import com.walletconnect.codingchallenge.data.ClothingRepository
import com.walletconnect.codingchallenge.util.assetManager
import com.walletconnect.codingchallenge.util.moshi

class ClothingViewModel: ViewModel() {
    private val clothingRepository by lazy { ClothingRepository(assetManager, moshi) }


}