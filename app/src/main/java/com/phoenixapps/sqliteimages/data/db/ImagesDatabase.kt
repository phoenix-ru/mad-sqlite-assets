package com.phoenixapps.sqliteimages.data.db

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import com.phoenixapps.sqliteimages.domain.model.Image
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

const val DB_NAME = "sunsetapp.db"
const val DB_VERSION = 1

class ImagesDatabase(context: Context): SQLiteAssetHelper(context, DB_NAME, null, DB_VERSION) {
    fun getImages(): List<Image> {
        val results = ArrayList<Image>()

        readableDatabase?.let {
            val cursor = it.rawQuery("select * from sunsetdata", null)

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val imageDescription = cursor.getString(0)
                    val imageData = cursor.getBlob(1)

                    results.add(Image(
                        imageDescription,
                        BitmapFactory.decodeByteArray(
                            imageData,
                            0,
                            imageData.size
                        )
                    ))
                }
            }

            cursor.close()
        }

        readableDatabase?.let {
            val cursor = it.rawQuery(
                "select count(*) from sunsetdata",
                null
            )

            while (cursor.moveToNext()) {
                Log.d("ImagesDB", "table: ${cursor.getInt(0)}")
            }

            cursor.close()
        }

        Log.d("ImagesDB", "getImages: " + results.size)

        return results
    }
}