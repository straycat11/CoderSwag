package com.roasloa.coderswag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.roasloa.coderswag.Model.Category
import com.roasloa.coderswag.Model.Product
import com.roasloa.coderswag.R
import kotlinx.android.synthetic.main.product_list_item.view.*

class ProductAdapter(val context: Context, val products: List<Product>, val itemClick: (Product)->Unit) : RecyclerView.Adapter<ProductAdapter.ProductHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item, p0, false)
        return ProductHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(p0: ProductHolder, p1: Int) {
        p0?.bindProduct(products[p1], context)
    }

    inner class ProductHolder(itemView: View?, val itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(itemView!!){
        val productImage = itemView?.findViewById<ImageView>(R.id.productImage)
        val productName = itemView?.findViewById<TextView>(R.id.productName)
        val productPrice = itemView?.findViewById<TextView>(R.id.productPrice)

        fun bindProduct(product: Product, context: Context) {
            val resourceId = context.resources.getIdentifier(product.image, "drawable",context.packageName)
            productImage?.setImageResource(resourceId)
            productName?.text = product.title
            productPrice?.text = product.price
            itemView.setOnClickListener{itemClick(product)}
        }
    }
}