package com.example.nhclass10practise.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nhclass10practise.R
import com.example.nhclass10practise.adapter.FoodAdapter
import com.example.nhclass10practise.data.db.AppDb
import com.example.nhclass10practise.model.FoodModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: FoodAdapter
    private lateinit var db: AppDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVar()
        initView()

    }

    private fun initVar() {

        db = AppDb.getInstance(this)
        insertFoodIntoDB()
        adapter = FoodAdapter(this, getItems() as ArrayList<FoodModel>)


    }


    private fun insertFoodIntoDB() {
//        val f1 = Food(1, "Orange", "", 1800)
//        db.foodDao().insert(f1)
//        val f2 = Food(2, "Apple", "", 1200)
//        db.foodDao().insert(f2)
//        val f3 = Food(3, "Banana", "", 2800)
//        db.foodDao().insert(f3)


        val f1 = FoodModel(1, "Orange", "https://homepages.cae.wisc.edu/~ece533/images/airplane.png", 1800)
        db.foodDao().insert(f1)
        val f2 = FoodModel(2, "Mango", "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png", 1200)
        db.foodDao().insert(f2)
        val f3 = FoodModel(3, "Banana", "https://homepages.cae.wisc.edu/~ece533/images/baboon.png", 2800)
        db.foodDao().insert(f3)

    }

    private fun getItems() = db.foodDao().all()


    private fun initView() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        rvFoods.adapter = adapter


    }
}
