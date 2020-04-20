package com.phoenixapps.sqliteimages.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phoenixapps.sqliteimages.R
import com.phoenixapps.sqliteimages.domain.model.Image
import kotlinx.android.synthetic.main.image_row.view.*

class ImagesAdapter: RecyclerView.Adapter<ImageHolder>() {
    private val images = ArrayList<Image>()

    fun changeDataSet(images: List<Image>) {
        this.images.clear()
        this.images.addAll(images)

        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.image_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return this.images.size
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(this.images[position])
    }

}