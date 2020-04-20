package com.phoenixapps.sqliteimages.presentation.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.phoenixapps.sqliteimages.domain.model.Image
import kotlinx.android.synthetic.main.image_row.view.*

class ImageHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(image: Image) {
        itemView.image_row_tv.text = image.description
        itemView.image_row_iv.setImageBitmap(image.data)
    }
}