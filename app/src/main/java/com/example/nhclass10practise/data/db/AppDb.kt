package com.example.nhclass10practise.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nhclass10practise.data.dao.FoodDao
import com.example.nhclass10practise.model.FoodModel

@Database(entities = [FoodModel::class], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun foodDao(): FoodDao

    companion object {
        private var instance: AppDb? = null

        fun getInstance(context: Context) = if (instance == null) create(context) else instance!!

        private fun create(context: Context) = Room.databaseBuilder(
            context,
            AppDb::class.java,
            "food"
        ).allowMainThreadQueries().build()
    }


}