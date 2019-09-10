package com.example.nhclass10practise.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nhclass10practise.model.FoodModel
import com.example.nhclass10practise.R
import com.example.nhclass10practise.data.db.AppDb
import kotlinx.android.synthetic.main.activity_main.*

class FoodAdapter(val context: Context, val items: ArrayList<FoodModel>) :
    RecyclerView.Adapter<FoodAdapter.MyFoodVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFoodVH {
        return MyFoodVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_home_food_list_row,
                parent,
                false
            )
        )


    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FoodAdapter.MyFoodVH, position: Int) {

        holder.bind(getItem(position))
    }

    fun getItem(pos: Int) = items[pos]

    inner class MyFoodVH(v: View) : RecyclerView.ViewHolder(v) {

        private var ivFood = v.findViewById<ImageView>(R.id.ivFood)
        private var tvName = v.findViewById<TextView>(R.id.tvName)
        private var tvPrice = v.findViewById<TextView>(R.id.tvPrice)

        fun bind(foodModel: FoodModel) {

            tvName.text = foodModel.name
            tvPrice.text = foodModel.price.toString()




            Glide.with(context)
                .load(foodModel.image)
                .into(ivFood)

            itemView.setOnClickListener {
                val db = AppDb.getInstance(context)
                db.foodDao().delete(foodModel)
                items.remove(foodModel)
                Toast.makeText(context, "The ${foodModel.name} is Deleted", Toast.LENGTH_SHORT).show()

                notifyDataSetChanged()

            }
        }
    }


}
