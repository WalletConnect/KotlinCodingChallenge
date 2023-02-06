package com.walletconnect.codingchallenge.data

import android.content.res.AssetManager
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.walletconnect.codingchallenge.data.model.ClothingItem
import com.walletconnect.codingchallenge.data.model.dto.ClothingItemDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.buffer
import okio.source

class ClothingRepository(private val assetManager: AssetManager, private val moshi: Moshi) {

    suspend fun fetchAllClothingItems(): List<ClothingItem> = withContext(Dispatchers.IO) {
        try {
            val inputStream = assetManager.open("clothing.json")
            val types = Types.newParameterizedType(List::class.java, ClothingItemDTO::class.java)
            val adapter = moshi.adapter<List<ClothingItemDTO>>(types)
            val listOfClothingItemsDto = adapter.fromJson(inputStream.source().buffer())!!

            listOfClothingItemsDto.map(ClothingItemDTO::toClothing)
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun fetchClothingItemById(id: Int): ClothingItem? = withContext(Dispatchers.IO) {
        try {
            val inputStream = assetManager.open("${id}.json")
            val adapter = moshi.adapter(ClothingItemDTO::class.java)
            val clothingDto = adapter.fromJson(inputStream.source().buffer())

            clothingDto?.toClothing()
        } catch (e: Exception) {
            null
        }
    }
}

private fun ClothingItemDTO.toClothing(): ClothingItem =
    ClothingItem(
        id,
        title,
        price,
        description,
        image
    )