package com.roasloa.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.roasloa.coderswag.Adapters.ProductAdapter
import com.roasloa.coderswag.R
import com.roasloa.coderswag.Services.DataService
import com.roasloa.coderswag.Utilities.EXTRA_CATEGORY
import com.roasloa.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductAdapter(this,DataService.getProducts(categoryType)){
                product ->
            val productsDetailIntent = Intent(this, ProductDetailActivity::class.java)
            productsDetailIntent.putExtra(EXTRA_PRODUCT, product)
            startActivity(productsDetailIntent)
        }

        var spanCount = 2

        val orientation = resources.configuration.orientation
        when(orientation){
            Configuration.ORIENTATION_LANDSCAPE -> spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        productsListView.layoutManager = layoutManager
        productsListView.adapter = adapter

    }
}
