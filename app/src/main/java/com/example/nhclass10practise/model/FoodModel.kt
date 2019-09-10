package com.example.nhclass10practise.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class FoodModel(
    @PrimaryKey(autoGenerate = false) var id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "image") var image: String,
    @ColumnInfo(name = "price") var price: Int
)
