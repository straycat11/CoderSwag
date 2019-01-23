package com.roasloa.coderswag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.roasloa.coderswag.Model.Category
import com.roasloa.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryRecycleAdapter(val context: Context,
                             val categories: List<Category>,
                             val itemClick : (Category)-> Unit) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.category_list_item, p0, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0?.bindCategory(categories[p1], context)
    }


    inner class Holder(itemView: View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView){
       val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
       val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category: Category, context: Context){
            val resourceId = context.resources.getIdentifier(category.image,
                "drawable", context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title
            itemView.setOnClickListener{itemClick(category)}
        }
    }
}