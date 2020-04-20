package com.phoenixapps.sqliteimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.phoenixapps.sqliteimages.data.db.ImagesDatabase
import com.phoenixapps.sqliteimages.presentation.recycler.ImagesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var imagesAdapter: ImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linkRecycler()
    }

    override fun onResume() {
        super.onResume()
        showImages()
    }

    private fun linkRecycler() {
        imagesAdapter = ImagesAdapter()

        images_rv.layoutManager = LinearLayoutManager(this)
        images_rv.adapter = imagesAdapter
    }

    private fun showImages() {
        imagesAdapter.changeDataSet(
            ImagesDatabase(this)
                .getImages()
        )
    }
}
