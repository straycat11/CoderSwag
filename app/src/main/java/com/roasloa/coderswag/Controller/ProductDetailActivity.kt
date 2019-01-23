package com.roasloa.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.roasloa.coderswag.Model.Product
import com.roasloa.coderswag.R
import com.roasloa.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        val productType = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)

        val resourceId = resources.getIdentifier(productType.image, "drawable",packageName)

        productDetailImage.setImageResource(resourceId)
        productDetailName.text = productType.title
        productDetailPrice.text = productType.price

    }
}
