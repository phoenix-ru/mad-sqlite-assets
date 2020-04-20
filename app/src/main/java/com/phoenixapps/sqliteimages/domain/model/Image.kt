package com.phoenixapps.sqliteimages.domain.model

import android.graphics.Bitmap

data class Image(
    val description: String,
    val data: Bitmap
)