package com.example.nhclass10practise.data.dao

import androidx.room.*
import com.example.nhclass10practise.model.FoodModel


@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(food: FoodModel)

    @Delete
    fun delete(food: FoodModel)

    @Query("select * from food")
    fun all(): List<FoodModel>
}